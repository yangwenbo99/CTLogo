package ctlogo.execute;

import java.util.List;

import ctlogo.execute.expression.Expression;

/**
 * 
 * @author Paul Yang
 *
 *
 * Implementation details:
 *     The class shall firstly translate the program to Reverse Polish 
 *     notation (RPN), then generate expression object based on the RPN 
 *     representation. 
 *     
 * To RPN: 
 * - Need to track on where is boundary of expression
 * - Need to put additional function call terminator RPN object
 * - A block and list shall be (recursively) parsed, and represented as an RPN 
 *   object
 *   
 * For each token: 
 * - Check whether it is an literal.
 *   If so, wrap it with RPNObject for Literal
 * - Check whether it is an operator.
 *   If so, check whether it is uniry or binary. 
 *     - If the last token is an operator or (begin of expression), it unary
 *     - Otherwise, its binary
 *   Construct a proper RPN object wrapper for UnaryOperator or 
 *   BinaryOperator respectively. 
 *   
 * - Check whether it looks like a variable
 *   If so, create a wrapper for variable expression 
 * - Check whether it is a function name.
 *   If so, create a RPNFunctionCall
 * - Check whether it is begin / end of list or block
 *   If so, (recursively) call and construct.
 * 
 * From RPN to Expression object:
 * - An uniry operator will eat one RPN object and put one RPN object 
 *   back to stack
 * - A binary operator will eat two and push two
 * - A function call will eat all RPN objects until function terminator 
 *   object eaten.
 * - The final RPN object possesses the final expression
 *     
 * These imply: 
 * - we need to distinguish between unary and binary '-'
 * - 
 */
public interface ExpressionStream {

    /**
     * Get the next expression from the stream. 
     *
     * Evaluate [ ] to value list, {} to block
     *
     * @return the next expression. 
     */
    public Expression getNextExpression();

    /**
     * Get the next code block from the stream.
     *
     * Evaluate { } and { } to block.
     *
     * @return the expressions in the block.
     */
    public List<Expression> geNextBlock();// 

    /**
     * Get the next string from the stream.
     *
     * Evaluate [ ] and 'string' and "str to string.
     *
     * @return the next string in the stream. 
     */
    public Expression getNextString(); 
}
