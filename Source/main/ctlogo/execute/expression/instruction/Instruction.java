/**
 * 
 */
package ctlogo.execute.expression.instruction;

import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.ExpressionStream;
import ctlogo.execute.expression.Expression;
import ctlogo.processing.TokenStream;

/**
 * Logo instructions.
 *
 * @author Paul Yang
 * @version 1.0
 *
 */
public interface Instruction {

	/**
	 * Get the expression corresponding to the instruction. 
	 * @param ts      the token stream containing the instruction.
	 * @param es      the expression stream managing the token stream
	 * @param isFirst is the instruction appear right after a 
	 *                left-parenthesis
	 * @return the corresponsing expression. 
	 *
	 * @throws CTSyntaxException if the syntax is incorrect.
	 *
	 * The first token to be get from this token stram should be the 
	 * first token of the instruction, usually the name of the instruction.
	 */
	Expression getExpression(
			TokenStream ts, 
			ExpressionStream es, 
			boolean isFirst
			) throws CTSyntaxException;

	/**
	 * Get the expression corresponding to the instruction. 
	 *
	 * @param ts the token stream containing the instruction.
	 * @return the corresponding expression. 
	 *
	 * This shall be equivalent to 
	 * <code>{@code getExpression(ts, es, false)}</code>, 
	 * and this is the default implementation of this method.
	 */
	default Expression getExpression(
			TokenStream ts, 
			ExpressionStream es 
			) throws CTSyntaxException {
		return getExpression(ts, es, false);
	}

}
