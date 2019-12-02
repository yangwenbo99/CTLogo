package ctlogo.execute.expression;

import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;

/**
 * Command to be executed.
 * 
 * <p>An OperatorExpreesion object shall have two constructors, one takes a 
 * {@code List<Expression>} as input, and the other one takes n 
 * Expression.</p>
 *
 * @author Paul Yang
 *
 */
public interface Expression {
	/**
	 * Execute the command in the given context.
	 *
	 * @param context the contest to execute in.
	 * @return return value of execution.
	 *
	 * @throws CTException if the execution has something wrong. 
	 */
	public CTValue execute(Context context) throws CTException;
}
