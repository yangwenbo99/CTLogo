package ctlogo.data;

import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cstr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ctlogo.exception.CTVariableNotDefinedException;

public class TestGlobalVariableManager {

    private GlobalVariableManager mgr = new GlobalVariableManager();

    @BeforeEach
    void initMgr() {
        mgr.setVariable("test1", cint(1));
    }

    @Test
    void testIsDefined() {
        // this will also cover all is defined locally
        Assertions.assertEquals(true, mgr.isDefined("test1"));
        Assertions.assertEquals(true, mgr.isDefined("tESt1"));
        Assertions.assertEquals(false, mgr.isDefined("tESt2"));
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mgr.isDefined(null));
    }

    @Test
    void testGetValue() {
        Assertions.assertEquals(cint(1), mgr.getValue("test1"));
        Assertions.assertThrows(
                CTVariableNotDefinedException.class,
                () -> mgr.getValue("test2"));
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mgr.getValue(null));
    }

    @Test
    void testSetValue() {
        // this will also cover tryGetValue

        // not defined 
        Assertions.assertNull(mgr.tryGetValue("test2"));
        mgr.setVariable("test2", cstr("Test2"));
        Assertions.assertEquals(
                cstr("Test2"), 
                mgr.tryGetValue("test2"));
        // already defined 
        mgr.setVariable("test2", cbol(true));
        Assertions.assertEquals(
                cbol(true),
                mgr.tryGetValue("test2"));

        // null
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mgr.setVariable("Test3", null));
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> mgr.setVariable(null, cint(1)));
    }

}
