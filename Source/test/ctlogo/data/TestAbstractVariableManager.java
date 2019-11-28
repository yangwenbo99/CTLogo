package ctlogo.data;

import static ctlogo.data.TestDataUtility.cint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.exception.CTVariableAlreadyDefinedException;
import ctlogo.exception.CTVariableNotDefinedException;

/**
 *
 *
 * @author Paul Yang
 *
 * Botton-up for this part, only test extra methods not tested in children.
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
    }

}
