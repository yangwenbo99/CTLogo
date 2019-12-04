package ctlogo.data;

import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.exception.CTOperationUndefinedException;

public class TestCTUndefined {
    @Test 
    void testAnd() {
        Assertions.assertEquals(cbol(false), CTUndefined.UNDEFINED.and(cbol(false)));
        Assertions.assertSame(CTUndefined.UNDEFINED, CTUndefined.UNDEFINED.and(cbol(true)));
    }

    @Test 
    void testOr() {
        Assertions.assertEquals(cbol(true), CTUndefined.UNDEFINED.or(cbol(true)));
        Assertions.assertSame(CTUndefined.UNDEFINED, CTUndefined.UNDEFINED.or(cbol(false)));
    }

    @Test
    void testEquals() {
        Assertions.assertEquals(cbol(false), CTUndefined.UNDEFINED.equals(cbol(true)));
        Assertions.assertEquals(cbol(false), CTUndefined.UNDEFINED.equals(cbol(false)));
    }

    @Test
    void testNot() {
        Assertions.assertSame(CTUndefined.UNDEFINED, CTUndefined.UNDEFINED.not());
    }

    @Test
    void testCompare() {
        Assertions.assertEquals(false, CTUndefined.UNDEFINED.isCompareableTo(cbol(false)));
        Assertions.assertThrows(CTOperationUndefinedException.class, 
                () -> CTUndefined.UNDEFINED.compareTo(cint(1)));
    }
    
    @Test
    void testTypeMarker() {
    	Assertions.assertEquals(
    			CTUndefined.UNDEFINED.getTypeMarker(), 
    			CTUndefined.getTypeMarkerStatic());
    }


}
