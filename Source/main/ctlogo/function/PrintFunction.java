/**
 * 
 */
package ctlogo.function;

import java.util.List;

import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;

/**
 * @author Paul Yang
 *
 */
public class PrintFunction extends AbstractFunction {
	
	private PrintFunction() { }
	
	private static PrintFunction theInstance = new PrintFunction();
	public static PrintFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}
	
	@Override
	public int getMinParameterNum() {
		return 0;
	}
	
	@Override
	public int getMaxParameterNum() {
		return -1;
	}

	@Override
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTValue last = CTUndefined.UNDEFINED;
		boolean isFirst = true;
		for (Expression param : params) {
			if (isFirst)
				isFirst = false;
			else
				ctx.getOutputStream().print(" ");
			last = param.execute(ctx);
			ctx.getOutputStream().print(last.toString());
		}
		ctx.getOutputStream().println();

		return last;
	}

}
