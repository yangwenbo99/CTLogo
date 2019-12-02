package ctlogo.function.math;

import java.util.List;

import ctlogo.data.CTDouble;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.function.AbstractFunction;

public class AtanFunction extends AbstractFunction {
	
	private AtanFunction () { }
	
	private static AtanFunction theInstance = new AtanFunction();
	
	public static AtanFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble v = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		return new CTDouble(Math.atan(v.getNumericalValue().doubleValue()));
	}
}