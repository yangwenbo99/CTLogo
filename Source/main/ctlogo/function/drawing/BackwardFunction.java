package ctlogo.function.drawing;

import java.util.ArrayList;
import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.NegativeOperator;
import ctlogo.function.AbstractFunction;

public class BackwardFunction extends AbstractFunction {
	
	private BackwardFunction () { }
	
	private static BackwardFunction theInstance = new BackwardFunction();
	
	public static BackwardFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		List<Expression> newParams = new ArrayList<>();
		newParams.add(new NegativeOperator(params.get(0)));
		return ForwardFunction.getInstance().execute(ctx, newParams);
	}
}
