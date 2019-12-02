package ctlogo.function.math;

import java.util.List;

import ctlogo.data.CTDouble;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.function.AbstractFunction;

public class Atan2Function extends AbstractFunction {
	
	private Atan2Function () { }
	
	private static Atan2Function theInstance = new Atan2Function();
	
	public static Atan2Function getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 2;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble v1 = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		CTDouble v2 = (CTDouble) 
				params.get(1).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		return new CTDouble(Math.atan2(
				v1.getNumericalValue().doubleValue(),
				v2.getNumericalValue().doubleValue()));
	}
}