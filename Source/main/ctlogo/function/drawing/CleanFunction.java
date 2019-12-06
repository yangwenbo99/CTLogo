package ctlogo.function.drawing;

import java.util.List;

import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.function.AbstractFunction;

/**
 * Clean the screen, without affecting the state of turtle
 * @author Paul Yang
 *
 */
public class CleanFunction extends AbstractFunction {
	
	private CleanFunction () { }
	
	private static CleanFunction theInstance = new CleanFunction();
	
	public static CleanFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 0;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		ctx.getScreen().clean();

		return CTUndefined.UNDEFINED;
	}
}