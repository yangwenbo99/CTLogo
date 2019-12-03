package ctlogo.function;

import static ctlogo.data.TestDataUtility.cint;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ctlogo.exception.CTException;
import ctlogo.execute.DummpExpression;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.LiteralExpression;

public class TestFunctionManager {
	@BeforeAll 
	static void prepare() {
		// register the dummy function
		FunctionManager.getInstace().register("Dummy", new StubFuntion());
		FunctionManager.getInstace().register("DummyN", new StubFuntion(), false);
	}
	
	@Test 
	void testFunctionManager() throws CTException {
		List<Expression> params = List.<Expression>of(new DummpExpression());
		Assertions.assertEquals(
				cint(1), 
				FunctionManager.getInstace().
					getFunctionExpression("Dummy", params).execute(null));
	}

	@Test
	void testRegister() throws CTException {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> FunctionManager.getInstace().register("Dummy", new StubFuntion()));
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> FunctionManager.getInstace().register("dummy", new StubFuntion()));
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> FunctionManager.getInstace().register("DuMmY", new StubFuntion()));
		Assertions.assertDoesNotThrow(
				() -> FunctionManager.getInstace().register("DuMmY2", new StubFuntion()));
	}

	@Test 
	void testReRegister() throws CTException {
		Assertions.assertEquals(
				true, 
				FunctionManager.getInstace().reRegister("dummy", new StubFuntion()));
		Assertions.assertThrows(UnsupportedOperationException.class,
				() -> FunctionManager.getInstace().reRegister("DummyN", new StubFuntion()));
		
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
	void testGetDefaultParameterNum() {
		Assertions.assertEquals(
				1, 
				FunctionManager.getInstace().getDefaultParameterNum("Dummy"));
		Assertions.assertThrows(NoSuchElementException.class,
				() -> 
					FunctionManager.getInstace().getDefaultParameterNum("DNE"));
	}
	
	@Test 
	void testGetMinParameterNum() {
		Assertions.assertEquals(
				1, 
				FunctionManager.getInstace().getMinParameterNum("Dummy"));
		Assertions.assertThrows(NoSuchElementException.class,
				() -> 
					FunctionManager.getInstace().getMinParameterNum("DNE"));
	}
	
	@Test 
	void testGetMaxParameterNum() {
		Assertions.assertEquals(
				1, 
				FunctionManager.getInstace().getMaxParameterNum("Dummy"));
		Assertions.assertThrows(NoSuchElementException.class,
				() -> 
					FunctionManager.getInstace().getMaxParameterNum("DNE"));
	}
}
