/**
 * 
 */
package ctlogo.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test {@link CTValue}. 
 * 
 * @author Paul Yang
 *
 */
public class TestCTVariable {
	
	private StubCTValue v1 = new StubCTValue();
	private StubCTValue v2 = new StubCTValue();
	private CTVariable var1 = new CTVariable();
	private CTVariable var2 = new CTVariable(v1);
	
	@Test 
	void testGetValue() {
		Assertions.assertSame(CTUndefined.UNDEFINED, var1.getValue());
		Assertions.assertSame(v1, var2.getValue());
	}
	
	@Test
	void testSetValue() {
		var1.setValue(v2);
		Assertions.assertSame(v2, var1.getValue());
	}
}
