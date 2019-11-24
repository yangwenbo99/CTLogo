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
 * @author Paul Yang
 *
 */
public class MakeFunction extends AbstractFunction {

	@Override
	public int getDefaultParameterNum() {
		return 2;
	}

	@Override
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTValue value = params.get(1).execute(ctx);
		ctx.getVariableManager().setVariable(
				params.get(0).toString(),
				value);
		return value;
	}

}
