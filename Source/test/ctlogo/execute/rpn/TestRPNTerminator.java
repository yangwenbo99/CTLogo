package ctlogo.execute.rpn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRPNTerminator {

	public TestRPNTerminator() {
	}
	
	@Test 
	void testTrival() {
		RPNObject rpn= RPNTerminator.getInstance();
		Assertions.assertEquals(false, rpn.isOperable());
		Assertions.assertEquals(false, rpn.isEvaluable());
		Assertions.assertEquals(true,  rpn.isTerminator());
	}
}
