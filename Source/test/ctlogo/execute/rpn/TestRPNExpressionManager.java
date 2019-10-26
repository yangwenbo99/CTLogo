package ctlogo.execute.rpn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.execute.DummpExpression;
import ctlogo.execute.rpn.RPNEvaluable;
import ctlogo.execute.rpn.RPNExpressionWrapper;

public class TestRPNExpressionManager {

    private static final RPNExpressionManager mgr = RPNExpressionManager.getInstance();

	@Test 
	void testTrivalGetOperator() {
        Assertions.assertEquals(
                2, 
                mgr.getBinaryOperator("+").getParameterNumber());
        Assertions.assertEquals(
                1, 
                mgr.getUnaryOperator("+").getParameterNumber());



	}
	

}
