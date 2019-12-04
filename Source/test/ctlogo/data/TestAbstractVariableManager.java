package ctlogo.data;

import static ctlogo.data.TestDataUtility.cint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.exception.CTVariableAlreadyDefinedException;
import ctlogo.exception.CTVariableNotDefinedException;

/**
 * Test AbstractVariableManager.
 *
 * Botton-up for this part, only test extra methods not tested in children.
 *
 * @author Paul Yang
 */
public class TestAbstractVariableManager {

    private GlobalVariableManager mgr = new GlobalVariableManager();

    @Test
    void testCreateLocalVariable() {
        mgr.createLocalVariable("AAA", cint(2));
        Assertions.assertThrows(
                CTVariableAlreadyDefinedException.class,
                () -> mgr.createLocalVariable("AAA", cint(1)));
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mgr.createLocalVariable("BBB", null));
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mgr.createLocalVariable(null, cint(1)));
    }

    @Test
    void testIsDefinedLocally() {
    	Assertions.assertFalse(mgr.isDefinedLocally("Var"));
    	mgr.createLocalVariable("Var", cint(1));
    	Assertions.assertTrue(mgr.isDefinedLocally("Var"));
    	Assertions.assertFalse(mgr.isDefinedLocally("VarDNE"));
    	Assertions.assertThrows(
    			IllegalArgumentException.class, 
    			() -> mgr.isDefinedLocally(null));
    }

    @Test
    void testSetLocalVariable() {
    	Assertions.assertEquals(null, mgr.setLocalVariable("VarL", cint(1)));
    	Assertions.assertEquals(cint(1), mgr.setLocalVariable("VarL", cint(2)));
    	Assertions.assertEquals(cint(2), mgr.getValue("VarL"));
    }

    /**
     * Test {@code: setLocalValue}.
     * 
     * Whether it returns correct result.
     */
    @Test
    void testSetLocalValue() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mgr.setLocalValue(null, cint(1)));
        Assertions.assertThrows(
                CTVariableNotDefinedException.class,
                () -> mgr.setLocalValue("AAA", cint(2)));
        mgr.createLocalVariable("AAA", cint(2));
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mgr.setLocalValue("AAA", null));
        Assertions.assertEquals(cint(2), mgr.setLocalValue("AAA", cint(3)));
    }
    
    @Test
    void testTryGetLocalValue() {
    	Assertions.assertEquals(null, mgr.tryGetLocalValue("DNE"));
    }

}
