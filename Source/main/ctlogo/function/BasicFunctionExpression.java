/**
 * 
 */
package ctlogo.function;

import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;

/**
 * The default function expression object generated by {@link AbstractFunction}.
 * 
 * @author Paul Yang
 *
 */
public class BasicFunctionExpression implements Expression {
	
	private AbstractFunction underliningFunction;
	private List<Expression> params;

	public BasicFunctionExpression(AbstractFunction underliningFunction,
			List<Expression> params) {
		super();
		this.underliningFunction = underliningFunction;
		this.params = params;
	}

	@Override
	public CTValue execute(Context context) throws CTException {
		return underliningFunction.execute(context, params);
	}

}