package ctlogo.data.convert;

import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cdbl;
import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cstr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTBoolean;
import ctlogo.data.CTDouble;
import ctlogo.data.CTInteger;
import ctlogo.data.CTString;

public class TestConverters {
	@Test
	void testFromInteger() {
		// To string
		Assertions.assertEquals(cstr("1"), cint(1).convertTo(CTString.getTypeMarkerStatic()));
		// To boolean
		Assertions.assertEquals(cbol(true), cint(1).convertTo(CTBoolean.getTypeMarkerStatic()));
		Assertions.assertEquals(cbol(false), cint(0).convertTo(CTBoolean.getTypeMarkerStatic()));
		// To double
		Assertions.assertEquals(cdbl(1), cint(1).convertTo(CTDouble.getTypeMarkerStatic()));
	}
	
	@Test
	void testFromBoolean() {
		CTBoolean TRUE = cbol(true);
		CTBoolean FALSE = cbol(false);
		
		// To integer
		Assertions.assertEquals(cint(1), TRUE.convertTo(CTInteger.getTypeMarkerStatic()));
		Assertions.assertEquals(cint(0), FALSE.convertTo(CTInteger.getTypeMarkerStatic()));

		// To double
		Assertions.assertEquals(cdbl(0), FALSE.convertTo(CTDouble.getTypeMarkerStatic()));

		// To string
		Assertions.assertEquals(cstr("true"), TRUE.convertTo(CTString.getTypeMarkerStatic()));
		Assertions.assertEquals(cstr("false"), FALSE.convertTo(CTString.getTypeMarkerStatic()));
	}

    @Test
    void testFromDouble() {
		// To str
		Assertions.assertEquals(cstr("1.5"), cdbl(1.5).convertTo(CTString.getTypeMarkerStatic()));
		// To boolean 
        Assertions.assertEquals(cbol(true), cdbl(Double.POSITIVE_INFINITY).convertTo(CTBoolean.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(false), cdbl(0).convertTo(CTBoolean.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(false), CTDouble.NaN.convertTo(CTBoolean.getTypeMarkerStatic()));
		// To integer
		Assertions.assertEquals(cint(1), cdbl(1.2).convertTo(CTInteger.getTypeMarkerStatic()));
    }

    @Test 
    void testFromString() {
        Assertions.assertEquals(cint(2),     cstr("2").convertTo(CTInteger.getTypeMarkerStatic()));
        Assertions.assertEquals(cint(2),     cstr("2.").convertTo(CTInteger.getTypeMarkerStatic()));
        Assertions.assertEquals(cdbl(2.0),   cstr("2.").convertTo(CTDouble.getTypeMarkerStatic()));
        Assertions.assertEquals(cdbl(2.0),   cstr("2.0").convertTo(CTDouble.getTypeMarkerStatic()));

		// To boolean
        Assertions.assertEquals(cbol(true),  cstr("TRUE").convertTo(CTBoolean.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(false), cstr("fAlSe").convertTo(CTBoolean.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(false), cstr("").convertTo(CTBoolean.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(false), cstr("0").convertTo(CTBoolean.getTypeMarkerStatic()));
        Assertions.assertEquals(cbol(true),  cstr("^&").convertTo(CTBoolean.getTypeMarkerStatic()));
    }
}
