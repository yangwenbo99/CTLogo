package ctlogo.execute.rpn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.execute.DummpExpression;
import ctlogo.execute.rpn.RPNEvaluable;
import ctlogo.execute.rpn.RPNExpressionWrapper;

public class TestRPNEvaluable {

	public TestRPNEvaluable() {
		// TODO Auto-generated constructor stub
	}
	
	@Test 
	void testTrivalWrapper() {
		RPNEvaluable rpneva = new RPNExpressionWrapper(new DummpExpression());
		Assertions.assertEquals((new DummpExpression()), rpneva.getExpression());
	}
	

}
