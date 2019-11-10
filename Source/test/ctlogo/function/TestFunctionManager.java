package ctlogo.function;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ctlogo.data.CTValue;
import ctlogo.execute.Context;

public class TestFunctionManager {
	@Test
	public void testOperators() {
		class StubFunction implements Function{
			@Override
			public CTValue execute(Context context, List<CTValue> cTValueList) {
				return null;
			}
			@Override
			public Integer getDefaultParameterNumber() {
				return null;
			}
			@Override
			public Integer getMinParameterNumber() {
				return null;
			}
			@Override
			public Integer getMaxParameterNumber() {
				return null;
			}			
		}
		
		Function testF = new StubFunction();
		Assertions.assertEquals(false, FunctionManager.hasFunction("testF"));
		FunctionManager.add("testF", testF);
		Assertions.assertEquals(true, FunctionManager.hasFunction("testF"));
		Assertions.assertEquals(testF, FunctionManager.getFunction("testF"));
		FunctionManager.delete("testF");
		Assertions.assertEquals(false, FunctionManager.hasFunction("testF"));
	}

}
