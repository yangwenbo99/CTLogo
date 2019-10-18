package ctlogo.execute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
