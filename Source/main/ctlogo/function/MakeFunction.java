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

	private MakeFunction() { }
	
	private static MakeFunction theInstance = new MakeFunction();
	public static MakeFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 2;
	}

	@Override
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTValue value = params.get(1).execute(ctx);
		CTValue name = params.get(0).execute(ctx);
		ctx.getVariableManager().setVariable(
				name.toString(),
				value);
		return value;
	}



}
