package ctlogo.data;

import static ctlogo.data.TestDataUtility.cint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLocalVariableManager {
	
	private static final int MAGIC_NUMBER = 12308234;
	
	static class StubVariableManager implements VariableManager {

		@Override
		public boolean isDefined(String name) {
			return isDefinedLocally(name);
		}

		@Override
		public boolean isDefinedLocally(String name) {
			return name.equals("test");
		}

		@Override
		public CTValue getValue(String name) {
			return cint(MAGIC_NUMBER);
		}

		@Override
		public CTValue tryGetValue(String name) {
			return cint(MAGIC_NUMBER);
		}

		@Override
		public CTValue setVariable(String name, CTValue value) {
			return cint(MAGIC_NUMBER);
		}

		@Override
		public CTValue setLocalVariable(String name, CTValue value) {
			return cint(MAGIC_NUMBER);
		}
	}

    private LocalVariableManager mgr = 
    		new LocalVariableManager(new StubVariableManager());

    @BeforeEach
    void initMgr() {
        mgr.setLocalVariable("testlocal1", cint(1));
    }

    @Test
    void testIsDefined() {
    	// local
        Assertions.assertEquals(true, mgr.isDefined("testlocal1"));
        // not local
        Assertions.assertEquals(true, mgr.isDefined("test"));
        Assertions.assertEquals(false, mgr.isDefined("test1"));
    }

    @Test
    void testGetValue() {
        Assertions.assertEquals(cint(1), mgr.getValue("testlocal1"));
        Assertions.assertEquals(cint(MAGIC_NUMBER), mgr.getValue("test"));
    }

    @Test
    void testSetValue() {
    	// local
    	Assertions.assertEquals(
    			cint(1), 
    			mgr.setVariable("testlocal1", cint(2)));
    	Assertions.assertEquals(
    			cint(2), 
    			mgr.getValue("testlocal1"));
    	// not local
    	Assertions.assertEquals(
    			cint(MAGIC_NUMBER), 
    			mgr.setVariable("test", cint(2)));
    	Assertions.assertEquals(
    			cint(MAGIC_NUMBER), 
    			mgr.getValue("test"));
    }
    
    @Test
    void testTryGetValue() {
    	// local
    	Assertions.assertEquals(
    			cint(1), 
    			mgr.tryGetValue("testlocal1"));
    	// not local
    	Assertions.assertEquals(
    			cint(MAGIC_NUMBER), 
    			mgr.tryGetValue("test"));
    }

}
