package ctlogo.function;

import java.util.List;

import ctlogo.data.CTDouble;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;

class SinFunction extends AbstractFunction {
	
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
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble v = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		return new CTDouble(Math.sin(v.getNumericalValue().doubleValue()));
	}
}

class CosFunction extends AbstractFunction {
	
	private CosFunction () { }
	
	private static CosFunction theInstance = new CosFunction();
	
	public static CosFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble v = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		return new CTDouble(Math.cos(v.getNumericalValue().doubleValue()));
	}
}

class TanFunction extends AbstractFunction {
	
	private TanFunction () { }
	
	private static TanFunction theInstance = new TanFunction();
	
	public static TanFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble v = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		return new CTDouble(Math.tan(v.getNumericalValue().doubleValue()));
	}
}

class AsinFunction extends AbstractFunction {
	
	private AsinFunction () { }
	
	private static AsinFunction theInstance = new AsinFunction();
	
	public static AsinFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble v = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		return new CTDouble(Math.asin(v.getNumericalValue().doubleValue()));
	}
}

class AcosFunction extends AbstractFunction {
	
	private AcosFunction () { }
	
	private static AcosFunction theInstance = new AcosFunction();
	
	public static AcosFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble v = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		return new CTDouble(Math.acos(v.getNumericalValue().doubleValue()));
	}
}

class AtanFunction extends AbstractFunction {
	
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
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble v = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		return new CTDouble(Math.atan(v.getNumericalValue().doubleValue()));
	}
}

class Atan2Function extends AbstractFunction {
	
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
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble v1 = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		CTDouble v2 = (CTDouble) 
				params.get(1).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		return new CTDouble(Math.atan2(
				v1.getNumericalValue().doubleValue(),
				v2.getNumericalValue().doubleValue()));
	}
}