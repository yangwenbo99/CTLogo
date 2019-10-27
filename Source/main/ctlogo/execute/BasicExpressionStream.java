/**
 * 
 */
package ctlogo.execute;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

import ctlogo.execute.expression.Expression;
import ctlogo.exception.CTSyntaxException;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.exception.CTLogicException;
import ctlogo.processing.TokenStream;
import ctlogo.processing.BasicTokenStream;
import ctlogo.execute.rpn.*;

/**
 * @author Paul Yang
 *
 * Implementation details:
 *     The class shall firstly translate the program to Reverse Polish 
 *     notation (RPN), then generate expression object based on the RPN 
 *     representation. 
 *     
 * When translating to RPN: 
 * - Need to track on where is boundary of expression
 * - Need to put additional function call terminator RPN object
 * - A block and list shall be (recursively) parsed, and represented as an RPN 
 *   object
 *   
 * The strategy of converting a stream of tokens to Expression is as defined 
 * in the {@link: ExpressionStream}.
 *
 * For each token: 
 * - Check whether it is an literal.
 *   If so, wrap it with {@code: RPNObject} for Literal
 *
 * - Check whether it is an operator.
 *   If so, check whether it is unary or binary. 
 *     - If the last token is an operator or (begin of expression), it unary
 *     - Otherwise, its binary
 *
 *   Construct a proper RPN object wrapper for {@code: UnaryOperator} or 
 *   {@code: BinaryOperator} respectively. 
 *   
 * - Check whether it looks like a variable
 *   If so, create a wrapper for variable expression 
 *
 * - Check whether it is a function name.
 *   If so, create a {@code: RPNFunctionCall}
 *
 * - Check whether it is begin / end of list or block
 *   If so, (recursively) call and construct.
 * 
 * - Otherwise, {@link: CTSyntaxException} shall be thrown.
 *
 */
public class BasicExpressionStream implements ExpressionStream {

    private TokenStream tokenStream;

    public BasicExpressionStream(TokenStream ts) {
        this.tokenStream = ts;
    }

    @Override
    public Expression getNextExpression() throws CTSyntaxException {
        int numExpectedExpression = 1;     // number of expressions to be processed
        boolean isLastOperator = true;    // is the last token just process operator?
        Stack<OperatorTokenMark> workingStack = new Stack<>();
        ArrayList<RPNObject> resList = new ArrayList<>();

        while (numExpectedExpression >= 0) {
            String token = tokenStream.popNext();
            // System.out.printf("(%s) ", token.replace("\n", "-Space-"));

            if (numExpectedExpression == 0 && 
                    BasicExpressionHelper.isLiteral(token)) {
                tokenStream.pushFront(token);
                break;
            }

            if (BasicExpressionHelper.isLiteral(token)) {
                resList.add(new RPNExpressionWrapper(BasicExpressionHelper.parseLiteral(token)));
                isLastOperator = false;
                numExpectedExpression--;
            } else if (
                    BasicExpressionHelper.isUnaryOperator(token) ||
                    BasicExpressionHelper.isBinaryOperator(token)
                    ) {
                OperatorTokenMark mark;
                if (isLastOperator) {
                    // This token must be unary operator
                    if (!BasicExpressionHelper.isUnaryOperator(token))
                        throw new CTSyntaxException(
                                "Binary operator used as unary");
                    mark = BasicExpressionHelper.constructUnaryOperator(token);
                } else {
                    // This token must be binary operator
                    numExpectedExpression++;
                    if (!BasicExpressionHelper.isBinaryOperator(token))
                        throw new CTSyntaxException(
                                "Unary operator used as binary");
                    mark = BasicExpressionHelper.constructBinaryOperator(token);
                }
                while (!workingStack.isEmpty() && 
                        workingStack.peek().getPrecedence() >= mark.getPrecedence()) {
                    resList.add(workingStack.pop().getRpnOperable());
                }
                workingStack.push(mark);
                isLastOperator = true;
            } else if (token.equals("(")) {
                workingStack.push(BasicExpressionHelper.constructLeftParenthesisMarker());
            } else if (token.equals(")")) {
                while (!workingStack.isEmpty() && 
                        !workingStack.peek().isLeftParenthesis()) {
                    resList.add(workingStack.pop().getRpnOperable());
                }
                if (workingStack.peek().isLeftParenthesis()) {
                    workingStack.pop();
                } else {
                    throw new RuntimeException("Error when analysing parenthesis (bug perhaps).");
                }
            } else if (false) {
                // check for variable (not supported yet) 
                // TODO: implement this part.
            } else if (false) {
                // check for function
                // TODO: implement this part
            } else if (false) {
                // check for begin/end of list or block
            } else if (token.equals("\n")) {
                numExpectedExpression = 0;
                break;
            }
        }
        while (!workingStack.isEmpty()) {
            resList.add(workingStack.pop().getRpnOperable());
        }

        try {
            List<Expression> resExpression = RPNExpressionExecutor.getInstance().execute(resList);
            if (resExpression.size() != 1) {
                for (Expression exp : resExpression ){
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

    public static void main(String [] args) {
        try (Scanner sc = new Scanner(System.in)) {
            TokenStream ts = new BasicTokenStream(sc);
            ExpressionStream es = new BasicExpressionStream(ts);
            while (true) {
                System.out.print(">>> ");
                CTValue res = es.getNextExpression().execute(null);
                System.out.printf("Executed to: %s, type %s\n",
                        res.toString(), 
                        res.getClass().toString());
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

