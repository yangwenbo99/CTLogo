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
		FunctionManager fm = new FunctionManager();
		Assertions.assertEquals(false, fm.hasFunction("testF"));
		fm.add("testF", testF);
		Assertions.assertEquals(true, fm.hasFunction("testF"));
		Assertions.assertEquals(testF, fm.getFunction("testF"));
		fm.delete("testF");
		Assertions.assertEquals(false, fm.hasFunction("testF"));
	}

}
