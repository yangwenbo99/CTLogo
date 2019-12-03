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
 * <p>This class provides a skeletal implementation of the {@link Function}
 * interface to minimise the effort required to implement this interface.</p>
 * 
 * <p> This class will do verification work when generating an 
 * {@link Expression} object. </p>
 * 
 * <p>To extend a concrete class from this abstract class, one need to 
 * implement two methods, {@link Function#getDefaultParameterNum()} and 
 * {@link #execute(Context, List)}, the later one will be the behaviour of 
 * the Logo function. On default, this method assumes that the Logo 
 * function only accepts exactly {@link Function#getDefaultParameterNum()}
 * parameters, i.e. no variable number of parameters, if this is not the case, 
 * override the two methods instead.</p>
 * 
 * @author Paul Yang
 *
 */
public abstract class AbstractFunction implements Function {

	/**
	 * Execute the function in the given context. 
	 * 
	 * @param ctx
	 * @return the return value of the function
	 * @throws CTException if exception detected
	 */
	abstract protected CTValue execute(Context ctx, List<Expression> params) throws CTException;
	
	/**
	 * Get the corresponding object to the function call. 
	 * This method will do verification work. 
	 * 
	 * @throws CTSyntaxException if the number of parameter is incorrect.
	 */
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
	 * Return the minimum number of allowed parameter.
	 * The default behaviour of this function is to return 
	 * {@link #getDefaultParameterNum()}
	 * 
	 * @return minimum number of allowed parameter.
	 */
	@Override
	public int getMinParameterNum() {
		return getDefaultParameterNum();
	}

	/**
	 * Return the maximum number of allowed parameter.
	 * The default behaviour of this function is to return 
	 * {@link #getDefaultParameterNum()}
	 * @return maximum number of allowed parameter, a negative number if unlimited.
	 */
	@Override
	public int getMaxParameterNum() {
		return getDefaultParameterNum();
	}

}
