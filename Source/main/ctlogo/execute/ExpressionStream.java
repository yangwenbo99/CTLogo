package ctlogo.execute;

import java.util.List;

import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.expression.Expression;

/**
 * 
 * @author Paul Yang
 *
 *
 * For each token: 
 *
 * - Check whether it is an literal.
 *   If so, regard it as an literal.
 *
 * - Check whether it is an operator.
 *   If so, check whether it is unary or binary. 
 *     - If the last token is an operator or (begin of expression), it unary
 *     - Otherwise, its binary
 *   
 * - Check whether it looks like a variable
 *   If so, regard it a variable. 
 *
 * - Check whether it is a function name.
 *   If so, create a {@code: RPNFunctionCall}
 *
 * - Check whether it is begin / end of list or block
 *   If so, (recursively) call and construct.
 *
 * - Otherwise, {@link: CTSyntaxException} shall be thrown.
 * 
 * These imply: 
 * - we need to distinguish between unary and binary '-'
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
    public List<Expression> geNextBlock() throws CTSyntaxException;

    /**
     * Get the next string from the stream.
     *
     * Evaluate [ ] and 'string' and "str to string.
     *
     * @return the next string in the stream. 
     */
    public Expression getNextString() throws CTSyntaxException; 
}
