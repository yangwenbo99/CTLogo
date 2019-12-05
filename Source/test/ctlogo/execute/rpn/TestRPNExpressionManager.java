package ctlogo.execute.rpn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRPNExpressionManager {

    private static final RPNOperationManager mgr = RPNOperationManager.getInstance();

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
