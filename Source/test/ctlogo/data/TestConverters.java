package ctlogo.data;

import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cdbl;
import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cstr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestConverters {
	
	@Test
	void testBoolean() {
		CTBoolean TRUE = cbol(true);
		CTBoolean FALSE = cbol(false);
		Assertions.assertEquals(cint(1), TRUE.convertTo(CTInteger.getTypeMarkerStatic()));
		Assertions.assertEquals(cint(0), FALSE.convertTo(CTInteger.getTypeMarkerStatic()));
		Assertions.assertEquals(cstr("true"), TRUE.convertTo(CTString.getTypeMarkerStatic()));
		Assertions.assertEquals(cstr("false"), FALSE.convertTo(CTString.getTypeMarkerStatic()));
	}

    @Test
    void testDouble() {
        Assertions.assertEquals(cbol(true), cdbl(Double.POSITIVE_INFINITY).convertTo(CTBoolean.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(false), cdbl(0).convertTo(CTBoolean.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(false), CTDouble.NaN.convertTo(CTBoolean.getTypeMarkerStatic()));
    }

    @Test 
    void testFromString() {
        Assertions.assertEquals(cint(2),     cstr("2").convertTo(CTInteger.getTypeMarkerStatic()));
        Assertions.assertEquals(cint(2),     cstr("2.").convertTo(CTInteger.getTypeMarkerStatic()));
        Assertions.assertEquals(cdbl(2.0),   cstr("2.").convertTo(CTDouble.getTypeMarkerStatic()));
        Assertions.assertEquals(cdbl(2.0),   cstr("2.0").convertTo(CTDouble.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(true),  cstr("TRUE").convertTo(CTBoolean.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(true),  cstr("^&").convertTo(CTBoolean.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(false), cstr("fAlSe").convertTo(CTBoolean.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(false), cstr("").convertTo(CTBoolean.getTypeMarkerStatic()));
    }
}
