package ctlogo.function.math;

import java.util.List;

import ctlogo.data.CTDouble;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.function.AbstractFunction;

public class SinFunction extends AbstractFunction {
	
	private SinFunction () { }
	
	private static SinFunction theInstance = new SinFunction();
	
	public static SinFunction getInstance() {
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
		return new CTDouble(Math.sin(v.getNumericalValue().doubleValue()));
	}
}