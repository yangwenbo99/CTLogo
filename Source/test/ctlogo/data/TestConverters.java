package ctlogo.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.*;
import ctlogo.exception.CTException;

public class TestConverters {
	private CTInteger cint(long i) {
		return new CTInteger(i);
	}

	private CTDouble cdbl(double v) {
		return new CTDouble(v);
	}

	private CTString cstr(String v) {
		return new CTString(v);
	}

	private CTBoolean cbol(boolean v) {
		return new CTBoolean(v);
	}
	
	@Test
	void testBoolean() {
		CTBoolean TRUE = cbol(true);
		CTBoolean FALSE = cbol(false);
		Assertions.assertEquals(cint(1), TRUE.convertTo(CTInteger.getTypeMarkerStatic()));
		Assertions.assertEquals(cint(0), FALSE.convertTo(CTInteger.getTypeMarkerStatic()));
		Assertions.assertEquals(cstr("true"), TRUE.convertTo(CTString.getTypeMarkerStatic()));
		Assertions.assertEquals(cstr("false"), FALSE.convertTo(CTString.getTypeMarkerStatic()));
	}
}
