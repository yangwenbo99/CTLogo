package ctlogo.execute.rpn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.execute.DummpExpression;

public class TestRPNEvaluable {

	public TestRPNEvaluable() {
	}
	
	@Test 
	void testTrivalWrapper() {
		RPNEvaluable rpneva = new RPNExpressionWrapper(new DummpExpression());
		Assertions.assertEquals((new DummpExpression()), rpneva.getExpression());
	}

	@Test 
	void testDefaultMethods() {
		RPNEvaluable rpneva = new RPNExpressionWrapper(new DummpExpression());
		Assertions.assertEquals(false, rpneva.isOperable());
		Assertions.assertEquals(true,  rpneva.isEvaluable());
		Assertions.assertEquals(false, rpneva.isTerminator());
	}
	

}
