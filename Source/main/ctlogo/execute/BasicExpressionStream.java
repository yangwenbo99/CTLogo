/**
 * 
 */
package ctlogo.execute;

import java.util.List;
import java.util.Stack;

import ctlogo.execute.expression.Expression;
import ctlogo.exception.CTSyntaxException;
import ctlogo.processing.TokenStream;
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
        boolean isLastOperator = false;    // is the last token operator
        Stack<RPNObject> workingStack = new Stack<>();

        while (numExpectedExpression > 0) {
            numExpectedExpression--;
            // String token = 
        }
		return null;
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
