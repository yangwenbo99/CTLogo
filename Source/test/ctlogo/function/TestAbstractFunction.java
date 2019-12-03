package ctlogo.function;

import static ctlogo.data.TestDataUtility.cint;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTInteger;
import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.LiteralExpression;

public class TestAbstractFunction {

	@Test 
	void testBasic() throws CTException {
		Function f = new StubFuntion();
		Expression exp = f.getFunctionExpression(List.<Expression>of(
				new LiteralExpression(CTUndefined.UNDEFINED)));
		Assertions.assertEquals(cint(1), exp.execute(null));
	}
	
	@Test
	void testWrongParameterNum() {
		Function f = new StubFuntion();
		Assertions.assertThrows(CTSyntaxException.class,
				() -> f.getFunctionExpression(List.<Expression>of(
						new LiteralExpression(CTUndefined.UNDEFINED),
						new LiteralExpression(CTUndefined.UNDEFINED),
						new LiteralExpression(CTUndefined.UNDEFINED)
						)));
		Assertions.assertThrows(CTSyntaxException.class,
				() -> f.getFunctionExpression(List.<Expression>of()));
	}
	

}

class StubFuntion extends AbstractFunction {
	
	private CTValue evalRes;
	
	public StubFuntion(CTValue evalRes) {
		super();
		this.evalRes = evalRes;
	}

	public StubFuntion() {
		this(CTInteger.ONE);
	}
	
	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		return evalRes;
	}
	
}