/**
 * 
 */
package ctlogo.function;

import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;

/**
 * @author yang
 *
 */
public abstract class AbstractFunction implements Function {

	/**
	 * Execute the function in the given context. 
	 * 
	 * @param ctx
	 * @return the return value of the function
	 * @throws CTException 
	 */
	abstract CTValue execute(Context ctx, List<Expression> params) throws CTException;
	
	@Override
	public Expression getFunctionExpression(List<Expression> params) 
			throws CTSyntaxException {
		if (params.size() < getMinParameterNum() || 
				(getMaxParameterNum() >= 0 && params.size() > getMaxParameterNum())) 
			throw new CTSyntaxException(
					String.format(
							"Wrong parameter number when calling the function %s" +
							"%d to %d expected, %d given",
							this.toString(),
							getMinParameterNum(), 
							getMaxParameterNum(),
							params.size()
							));
		return new BasicFunctionExpression(this, params);
	}

	/**
	 * @return minimum number of allowed parameter.
	 * 
	 * The default behaviour of this function is to return 
	 * {@link: #getDefaultParameterNum()}
	 */
	@Override
	public int getMinParameterNum() {
		return getDefaultParameterNum();
	}

	/**
	 * @return maximum number of allowed parameter, a negative number if unlimited.
	 * 
	 * The default behaviour of this function is to return 
	 * {@link: #getDefaultParameterNum()}
	 */
	@Override
	public int getMaxParameterNum() {
		return getDefaultParameterNum();
	}

}
