package ctlogo.function;

import java.util.List;

import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.expression.Expression;

/**
 * An object representing a Logo function. 
 *
 * <p> A function may accept zero or more parameter, and a funtion must have
 * a pre-defined default parameter number</p>
 *
 * @author Paul Yang
 *
 */
public interface Function {
	
	/**
	 * Get the corresponding object to the function call. 
	 *
	 * @param params the parameter(s) of the function call
	 * @return the return corresponding object.
	 *
	 * @throws CTSyntaxException if a syntax exception is detected, for 
	 * example incorrect number of parameters. 
	 */
	Expression getFunctionExpression(List<Expression> params) throws CTSyntaxException;

	/**
	 * Return the default number of parameter
	 * @return the default number of parameter
	 */
	int getDefaultParameterNum();

	/**
	 * Return the minimum number of allowed parameter.
	 * @return minimum number of allowed parameter.
	 */
	int getMinParameterNum();

	/**
	 * Return the maximum number of allowed parameter.
	 * @return maximum number of parameter, negative number if no limit.
	 */
	int getMaxParameterNum();
}
