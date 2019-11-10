package ctlogo.data;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestCTVariableManager {
	@Test
	public void testCTVariableManagerOperator() {
		CTValue testB = new CTBoolean(true);
		CTVariableManager vm = new CTVariableManager();
		Assertions.assertEquals(false, vm.isDefined("testB"));
		vm.setValue("testB", testB);
		Assertions.assertEquals(true, vm.isDefined("testB"));
		Assertions.assertEquals(testB, vm.getValue("testB"));
		vm.delete("testB");
		Assertions.assertEquals(false, vm.isDefined("testB"));
	}
	//TODO Test other function like outer valu which i don't quite understand
}
