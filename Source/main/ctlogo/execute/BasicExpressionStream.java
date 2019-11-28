/**
 * 
 */
package ctlogo.execute;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

import ctlogo.exception.CTLogicException;
import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.VariableExpression;
import ctlogo.execute.rpn.RPNExpressionExecutor;
import ctlogo.execute.rpn.RPNExpressionWrapper;
import ctlogo.execute.rpn.RPNObject;
import ctlogo.processing.TokenStream;

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

	private class ExpressionGetter {
		private int numExpectedExpression = 1; // number of expressions to be processed
		private int numOpenParenthesis = 0;
		private Stack<OperatorTokenMark> workingStack = new Stack<>();
		private ArrayList<RPNObject> resList = new ArrayList<>();
		
		abstract class State {
			private String token;

			public State(String token) {
				super();
				this.token = token;
			}

			String getToken() {
				return token;
			}

			abstract void enter() throws CTSyntaxException;
			/**
			 * @param token the token to be accepted 
			 * @return whether one should continue state transition. 
			 * @throws CTSyntaxException 
			 */
			abstract boolean accept(String token) throws CTSyntaxException;
		}
		
		abstract class OperatorState extends State {
			
			/**
			 * @param token the token to be accepted 
			 * 
			 * This method shall handle all cases, except 
			 * Operator -> Operator, in this case, the sub-classes shall 
			 * do the job. 
			 * @throws CTSyntaxException 
			 * 
			 */
			boolean accept(String token) throws CTSyntaxException {
				if (isOperatorToken(token)) {
					// This token must be unary operator
					enterState(new UnaryOperatorState(token));
				} else if (BasicExpressionHelper.isLiteral(token)) {
					enterState(new LiteralState(token));
				} else if (BasicExpressionHelper.isLikeVariable(token)) {
					enterState(new VariableState(token));
				} else if (BasicExpressionHelper.isFunction(token)) {
					enterState(new DefaultFunctionState(token));
				} else if (token.equals("(")) {
					enterState(new OpenParenthesisState(token));
				} else if (token.equals("\n")) {
					throw new CTSyntaxException(String.format(
							"Unexpected new line"));
				} else {
					throw new CTSyntaxException(String.format(
							"Putting non-operable %s after operator %s",
							token,
							getToken()));
				}
				return true;
			}

			public OperatorState(String token) {
				super(token);
			}

			void enter() throws CTSyntaxException {
				OperatorTokenMark mark = getMark();
				while (
						!workingStack.isEmpty() && 
						workingStack.peek().getPrecedence() >= mark.getPrecedence()) {
					resList.add(workingStack.pop().getRpnOperable());
				}
				workingStack.push(mark);
			}
			
			abstract OperatorTokenMark getMark() throws CTSyntaxException;

		}
		
		class UnaryOperatorState extends OperatorState {
			public UnaryOperatorState(String token) {
				super(token);
			}

			@Override
			OperatorTokenMark getMark() throws CTSyntaxException {
				if (!BasicExpressionHelper.isUnaryOperator(getToken()))
					throw new CTSyntaxException("Binary operator used as unary");
				return BasicExpressionHelper.constructUnaryOperator(getToken());
			}
		}
		
		class BinaryOperatorState extends OperatorState {
			public BinaryOperatorState(String token) {
				super(token);
			}

			@Override
			OperatorTokenMark getMark() throws CTSyntaxException {
				numExpectedExpression++;
				if (!BasicExpressionHelper.isBinaryOperator(getToken()))
					throw new CTSyntaxException("Unary operator used as binary");
				return BasicExpressionHelper.constructBinaryOperator(getToken());
			}
		}
		
		abstract class OperableState extends State {
			
			public OperableState(String token) {
				super(token);
			}

			boolean accept(String token) throws CTSyntaxException {
				assert(numExpectedExpression == 0);
				if (
						isOperableToken(token) || 
						token.equals("(") || 
						token.equals("\n")) {
					// tailing "\n" shall be pushed back as a mark
					return false;
				}
				
				if (BasicExpressionHelper.isBinaryOperator(token)) {
					enterState(new BinaryOperatorState(token));
				} else if (token.equals(")")) {
					if (numOpenParenthesis == 0) {
						return false;
					}
					enterState(new CloseParemthesisState(token));
				} else if (token.equals("\n")) {
					// nothing to do 
				} else {
					throw new CTSyntaxException("Unknown token " + token);
				}
				
				return true;
			}

			void enter() throws CTSyntaxException {
				resList.add(getRPNObject());
				numExpectedExpression--;
				
			}
			
			abstract RPNObject getRPNObject() throws CTSyntaxException;
				
		}
		
		class LiteralState extends OperableState {

			public LiteralState(String token) {
				super(token);
			}

			@Override
			RPNObject getRPNObject() throws CTSyntaxException {
				return new RPNExpressionWrapper(BasicExpressionHelper.parseLiteral(getToken()));
			}
			
		}

		class VariableState extends OperableState {

			public VariableState(String token) {
				super(token);
			}

			@Override
			RPNObject getRPNObject() throws CTSyntaxException {
				return new RPNExpressionWrapper(new VariableExpression(getToken().substring(1)));
			}
			
		}
		
		class DefaultFunctionState extends OperableState {

			public DefaultFunctionState(String token) {
				super(token);
			}

			@Override
			RPNObject getRPNObject() throws CTSyntaxException {
				List<Expression> params = nextn(BasicExpressionHelper.getDefaultParamNum(getToken()));
				Expression fexp = BasicExpressionHelper.constructFunctionExpression(getToken(), params);
				return new RPNExpressionWrapper(fexp);
			}
			
		}
		
		class ComplexFunctionState extends OperableState {

			public ComplexFunctionState(String token) {
				super(token);
			}

			@Override
			RPNObject getRPNObject() throws CTSyntaxException {
				List<Expression> params = getUntil(")");
				tokenStream.popNext();
				Expression fexp = BasicExpressionHelper.constructFunctionExpression(getToken(), params);
				return new RPNExpressionWrapper(fexp);
			}
			
		}
		
		class OpenParenthesisState extends State {

			public OpenParenthesisState(String token) {
				super(token);
			}

			@Override
			void enter() throws CTSyntaxException {
				workingStack.push(BasicExpressionHelper.constructLeftParenthesisMarker());
				numOpenParenthesis++;
			}

			@Override
			boolean accept(String token) throws CTSyntaxException {
				if (BasicExpressionHelper.isFunction(token)) {
					workingStack.pop();
					enterState(new ComplexFunctionState(token));
				} else if (BasicExpressionHelper.isLiteral(token)) {
					enterState(new LiteralState(token));
				} else if (BasicExpressionHelper.isLikeVariable(token)) {
					enterState(new VariableState(token));
				} else if (token.equals("(")) {
					enterState(new OpenParenthesisState(token));
				} else if (isOperatorToken(token)) {
					// This token must be unary operator
					enterState(new UnaryOperatorState(token));
				} else {
					throw new CTSyntaxException("Unknown token " + token);
				}
				return true;
			}
			
		}
		
		class CloseParemthesisState extends State {

			public CloseParemthesisState(String token) {
				super(token);
			}

			@Override
			void enter() throws CTSyntaxException {
				numOpenParenthesis--;

				while (!workingStack.isEmpty() && !workingStack.peek().isLeftParenthesis()) {
					resList.add(workingStack.pop().getRpnOperable());
				}
				if (workingStack.peek().isLeftParenthesis()) {
					workingStack.pop();
				} else {
					throw new RuntimeException("Error when analysing parenthesis (bug perhaps).");
				}
				
			}

			@Override
			boolean accept(String token) throws CTSyntaxException {
				// FIXME: this part is the same as another method 
				assert(numExpectedExpression == 0);
				if (
						isOperableToken(token) || 
						token.equals("(") || 
						token.equals("\n")) {
					// tailing "\n" shall be pushed back as a mark
					return false;
				}
				
				if (BasicExpressionHelper.isBinaryOperator(token)) {
					enterState(new BinaryOperatorState(token));
				} else if (token.equals(")")) {
					// TODO: Seems this part is effiectively dead
					if (numOpenParenthesis == 0) {
						return false;
					}
					enterState(new CloseParemthesisState(token));
				} else if (token.equals("\n")) {
					// nothing to do 
				} else {
					throw new CTSyntaxException("Unknown token " + token);
				}
				
				return true;
			}
			
		}
		
		private State state;
		
		void enterState(State state) throws CTSyntaxException {
			this.state = state;
			state.enter();
		}
		
		private boolean isOperatorToken(String token) { 
			return 
					BasicExpressionHelper.isUnaryOperator(token) || 
					BasicExpressionHelper.isBinaryOperator(token);
		}
		
		private boolean isOperableToken(String token) {
			return 
					BasicExpressionHelper.isLiteral(token) ||
					BasicExpressionHelper.isFunction(token) ||
					BasicExpressionHelper.isLikeVariable(token);
		}

		// this method is made package-visible on purpose. 
		List<Expression> getUntil(String endToken) throws CTSyntaxException {
			List<Expression> params = new ArrayList<>();
			while (!tokenStream.getNext().equals(")")) {
				params.add((new ExpressionGetter()).next());
			}
			return params;
		}
		
		// this method is made package-visible on purpose. 
		List<Expression> nextn(int n) throws CTSyntaxException {
			List<Expression> res = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				res.add((new ExpressionGetter()).next());
			}
			return res;
		}
		
		public Expression next() throws CTSyntaxException {
			/*
			 * A token may be 
			 * - Literal
			 * - Variable 
			 * - Function
			 * - Operator
			 *     - unary
			 *     - binary
			 * - ( or )    
			 * 
			 */

			String token = tokenStream.popNext();
			while (token.trim().equals(""))
				token = tokenStream.popNext();

			if (BasicExpressionHelper.isLiteral(token)) {
				enterState(new LiteralState(token));
			} else if (BasicExpressionHelper.isLikeVariable(token)) {
				enterState(new VariableState(token));
			} else if (BasicExpressionHelper.isFunction(token)) {
				enterState(new DefaultFunctionState(token));
			} else if (token.equals("(")) {
				enterState(new OpenParenthesisState(token));
			} else {
				throw new CTSyntaxException("Unknown token " + token);
			}
			// TODO: Blocks & instructions 
			// System.out.printf("<%d>", numExpectedExpression);

			while (true) {
				token = tokenStream.popNext();
				if (!state.accept(token)) {
					tokenStream.pushFront(token);
					break;
				}
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
			} catch (Exception e) {
				for (RPNObject exp : resList) {
					System.err.println(">>> " + exp.toString());
				}
				e.printStackTrace();
				throw e;
			}
			
		}
		
	}

	/**
	 * @return The next exception
	 *
	 * @throws CTSyntaxException
	 * @throws NoSuchElementException if no such exp
	 */
	@Override
	public Expression getNextExpression() throws CTSyntaxException {
		return (new ExpressionGetter()).next();
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


}
