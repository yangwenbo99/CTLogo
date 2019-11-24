/**
 * 
 */
package ctlogo.execute;

import java.util.List;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.VariableExpression;
import ctlogo.exception.CTSyntaxException;
import ctlogo.data.CTValue;
import ctlogo.data.GlobalVariableManager;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.exception.CTLogicException;
import ctlogo.processing.TokenStream;
import ctlogo.processing.BasicTokenStream;
import ctlogo.execute.rpn.*;
import ctlogo.graphic.Screen;

/**
 * @author Paul Yang
 *
 *         Implementation details: The class shall firstly translate the program
 *         to Reverse Polish notation (RPN), then generate expression object
 *         based on the RPN representation.
 * 
 *         When translating to RPN: - Need to track on where is boundary of
 *         expression - Need to put additional function call terminator RPN
 *         object - A block and list shall be (recursively) parsed, and
 *         represented as an RPN object
 * 
 *         The strategy of converting a stream of tokens to Expression is as
 *         defined in the {@link: ExpressionStream}.
 *
 *         For each token: - Check whether it is an literal. If so, wrap it with
 *         {@code: RPNObject} for Literal
 *
 *         - Check whether it is an operator. If so, check whether it is unary
 *         or binary. - If the last token is an operator or (begin of
 *         expression), it unary - Otherwise, its binary
 *
 *         Construct a proper RPN object wrapper for {@code: UnaryOperator} or
 *         {@code: BinaryOperator} respectively.
 * 
 *         - Check whether it looks like a variable If so, create a wrapper for
 *         variable expression
 *
 *         - Check whether it is a function name. If so, create a
 *         {@code: RPNFunctionCall}
 *
 *         - Check whether it is begin / end of list or block If so,
 *         (recursively) call and construct.
 * 
 *         - Otherwise, {@link: CTSyntaxException} shall be thrown.
 *
 */
public class BasicExpressionStream implements ExpressionStream {

	private TokenStream tokenStream;

	public BasicExpressionStream(TokenStream ts) {
		this.tokenStream = ts;
	}

	private List<Expression> getNextNExpressions(int n) throws CTSyntaxException {
		List<Expression> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			res.add(getNextExpression());
		}
		return res;
	}

	@SuppressWarnings("unused")
	private List<RPNObject> wrap(Iterable<Expression> exps) {
		List<RPNObject> res = new ArrayList<>();
		for (Expression exp : exps) {
			res.add(new RPNExpressionWrapper(exp));
		}
		return res;
	}

	@Override
	public Expression getNextExpression() throws CTSyntaxException {
		int numExpectedExpression = 1; // number of expressions to be processed
		int numOpenParenthesis = 0;
		boolean isLastOperator = true; // is the last token just process operator?
		Stack<OperatorTokenMark> workingStack = new Stack<>();
		ArrayList<RPNObject> resList = new ArrayList<>();

		while (numExpectedExpression >= 0) {
			String token = tokenStream.popNext();
			// System.out.printf("(%s) ", token.replace("\n", "-Space-"));

			if (numExpectedExpression == 0
					&& (BasicExpressionHelper.isLiteral(token) || token.equals("(") || token.equals("\n"))) {
				// tailing "\n" shall be pushed back as a mark
				// System.out.printf("(pushback)");
				tokenStream.pushFront(token);
				// System.out.printf("(PUSHBACK)");
				break;
			}

			if (BasicExpressionHelper.isLiteral(token)) {
				resList.add(new RPNExpressionWrapper(BasicExpressionHelper.parseLiteral(token)));
				isLastOperator = false;
				numExpectedExpression--;
			} else if (BasicExpressionHelper.isUnaryOperator(token) || BasicExpressionHelper.isBinaryOperator(token)) {
				OperatorTokenMark mark;
				if (isLastOperator) {
					// This token must be unary operator
					if (!BasicExpressionHelper.isUnaryOperator(token))
						throw new CTSyntaxException("Binary operator used as unary");
					mark = BasicExpressionHelper.constructUnaryOperator(token);
				} else {
					// This token must be binary operator
					numExpectedExpression++;
					if (!BasicExpressionHelper.isBinaryOperator(token))
						throw new CTSyntaxException("Unary operator used as binary");
					mark = BasicExpressionHelper.constructBinaryOperator(token);
				}
				while (!workingStack.isEmpty() && workingStack.peek().getPrecedence() >= mark.getPrecedence()) {
					resList.add(workingStack.pop().getRpnOperable());
				}
				workingStack.push(mark);
				isLastOperator = true;
			} else if (token.equals("(") && !BasicExpressionHelper.isFunction(tokenStream.getNext())) {
				workingStack.push(BasicExpressionHelper.constructLeftParenthesisMarker());
				numOpenParenthesis++;
			} else if (token.equals(")")) {
				if (numOpenParenthesis == 0) {
					tokenStream.pushFront(")");
					if (numExpectedExpression != 0) {
						throw new CTSyntaxException("Unexpected closing paranthesis");
					} else {
						break;
					}
				}
				numOpenParenthesis--;

				while (!workingStack.isEmpty() && !workingStack.peek().isLeftParenthesis()) {
					resList.add(workingStack.pop().getRpnOperable());
				}
				if (workingStack.peek().isLeftParenthesis()) {
					workingStack.pop();
				} else {
					throw new RuntimeException("Error when analysing parenthesis (bug perhaps).");
				}
			} else if (token.length() > 0 && token.charAt(0) == ':') {
				// check for variable 
				resList.add(new RPNExpressionWrapper(new VariableExpression(
						token.substring(1))));
				isLastOperator = false;
				numExpectedExpression--;
			} else if (token.equals("(") && BasicExpressionHelper.isFunction(tokenStream.getNext())) {
				String fname = tokenStream.popNext();
				List<Expression> params = new ArrayList<>();
				while (!tokenStream.getNext().equals(")")) {
					params.add(getNextExpression());
				}
				tokenStream.popNext();
				Expression fexp = BasicExpressionHelper.constructFunctionExpression(fname, params);
				resList.add(new RPNExpressionWrapper(fexp));
				numExpectedExpression--;
				isLastOperator = false;
			} else if (BasicExpressionHelper.isFunction(token)) {
				List<Expression> params = getNextNExpressions(BasicExpressionHelper.getDefaultParamNum(token));
				Expression fexp = BasicExpressionHelper.constructFunctionExpression(token, params);
				resList.add(new RPNExpressionWrapper(fexp));
				numExpectedExpression--;
				isLastOperator = false;
			} else if (false) {
				// check for begin/end of list or block
			} else if (token.equals("\n")) {
				// System.out.printf(" -Cont- ");
				continue;
			} else {
				// System.out.printf(" -Cont- ");
				throw new CTSyntaxException("Unknown token " + token);
			}
			// System.out.printf("<%d>", numExpectedExpression);
		}

		while (!workingStack.isEmpty()) {
			resList.add(workingStack.pop().getRpnOperable());
		}

		// System.out.printf(" -Return- ");
		try {
			List<Expression> resExpression = RPNExpressionExecutor.getInstance().execute(resList);
			if (resExpression.size() != 1) {
				for (Expression exp : resExpression) {
					System.err.println(">>> " + exp.toString());
				}
				throw new RuntimeException("Only one expression expected. (This is likely to be a bug)");
			}
			return resExpression.get(0);
		} catch (CTLogicException e) {
			throw new CTSyntaxException("Invalid syntax", e);
		}
	}

	@Override
	public List<Expression> geNextBlock() throws CTSyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression getNextString() throws CTSyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

		/*
		 * Try the following input, they should not trigger any error. 1 1 1 1 + 2 1 +
		 * (2 * 3) 1 + (+2 * 3) (-2 * 5) + 2 PR 1 + 2 PR 32 + 34 PR 32 + 34 6 (PR 1 + 2
		 * 4) * 7
		 */

		class StubContext extends AbstractContext {
			public StubContext(Scanner scanner, PrintStream outputStream, Screen screen,
					VariableManager variableManager) {
				super(scanner, outputStream, screen, variableManager);
			}
		}

		Context stubContext = new StubContext(
				null, 
				System.out, 
				null, 
				new GlobalVariableManager());

		try (Scanner sc = new Scanner(System.in)) {
			TokenStream ts = new BasicTokenStream(sc);
			ExpressionStream es = new BasicExpressionStream(ts);
			while (true) {
				System.out.print(">>> ");
				CTValue res = es.getNextExpression().execute(stubContext);
				System.out.printf("Executed to: %s, type %s\n", res.toString(), res.getClass().toString());
			}
		} catch (CTSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
