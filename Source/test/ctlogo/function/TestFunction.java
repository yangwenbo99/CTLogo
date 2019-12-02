package ctlogo.function;

import static ctlogo.data.TestDataUtility.cint;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTInteger;
import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.Context;
import ctlogo.execute.DummpExpression;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.LiteralExpression;

public class TestFunction {
	
	@BeforeAll 
	static void prepare () {
		// register the dummy function
		FunctionManager.getInstace().register("Dummy", new StubFuntion());
	}

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
				() -> f.getFunctionExpression(List.<Expression>of()));
	}
	
	@Test 
	void testReRegister() throws CTException {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> FunctionManager.getInstace().register("Dummy", new StubFuntion()));
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> FunctionManager.getInstace().register("dummy", new StubFuntion()));
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> FunctionManager.getInstace().register("DuMmY", new StubFuntion()));
		Assertions.assertDoesNotThrow(
				() -> FunctionManager.getInstace().register("DuMmY2", new StubFuntion()));
		
		
		
		Assertions.assertThrows(NoSuchElementException.class,
				() -> 
					FunctionManager.getInstace().getFunctionExpression(
							"dummyF1", List.<Expression>of(new LiteralExpression(cint(1))))
							.execute(null));

		FunctionManager.getInstace().register("DummyF1", new StubFuntion(cint(1)));
		Assertions.assertEquals(cint(1), 
				FunctionManager.getInstace().getFunctionExpression(
						"dummyF1", List.<Expression>of(new LiteralExpression(cint(1)))).execute(null));
		FunctionManager.getInstace().reRegister("DummyF1", new StubFuntion(cint(2)));
		Assertions.assertEquals(cint(2), 
				FunctionManager.getInstace().getFunctionExpression(
						"dummyF1", List.<Expression>of(new LiteralExpression(cint(1)))).execute(null));
		
	}
	
	@Test 
	void testFunctionManager() throws CTException {
		List<Expression> params = List.<Expression>of(new DummpExpression());
		Assertions.assertEquals(
				cint(1), 
				FunctionManager.getInstace().
					getFunctionExpression("Dummy", params).execute(null));
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