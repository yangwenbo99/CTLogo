package ctlogo.execute;

import java.util.List;

import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.expression.Expression;

/**
 * The stream of Expression. 
 *
 *
 * <p>For each token: </p>
 *
 * <ul>
 * <li> Check whether it is an literal.
 *   If so, regard it as an literal.</li>
 *
 * <li> Check whether it is an operator.
 *   If so, check whether it is unary or binary. 
 *     - If the last token is an operator or (begin of expression), it unary
 *     - Otherwise, its binary</li>
 *   
 * <li> Check whether it looks like a variable
 *   If so, regard it a variable. </li>
 *
 * <li> Check whether it is a function name.</li>
 *
 * <li> Check whether it is a instruction name.</li>
 *
 * <li> Check whether it is begin / end of list or block
 *   If so, (recursively) call and construct.</li>
 *
 * <li> Otherwise, {@link CTSyntaxException} shall be thrown.</li>
 * </ul>
 * 
 * These imply that we need to distinguish between unary and binary '-'
 *
 * @author Paul Yang
 */
public interface ExpressionStream {

    /**
     * Get the next expression from the stream. 
     *
     * Evaluate [ ] to value list, {} to block
     *
     * @return the next expression. 
     */
    public Expression getNextExpression() throws CTSyntaxException;

    /**
     * Get the next code block from the stream.
     *
     * Evaluate { } and { } to block.
     *
     * @return the expressions in the block.
     */
    public List<Expression> getNextBlock() throws CTSyntaxException;

    /**
     * Get the next string from the stream.
     *
     * Evaluate [ ] and 'string' and "str to string.
     *
     * @return the next string in the stream. 
     */
    public Expression getNextString() throws CTSyntaxException; 
}
