package ctlogo.function;

import java.util.List;

import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.expression.Expression;

/**
 * @author yang
 *
 */
public interface Function {
	
	Expression getFunctionExpression(List<Expression> params) throws CTSyntaxException;

	/**
	 * @return the default number of parameter
	 */
	int getDefaultParameterNum();

	/**
	 * @return minimum number of allowed parameter.
	 */
	int getMinParameterNum();

	/**
	 * @return maximum number of parameter, negative number if no limit.
	 */
	int getMaxParameterNum();
}
