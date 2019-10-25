package ctlogo.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.*;
import ctlogo.exception.CTException;

public class TestData {
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
    void testStupidBoolean() {
    	Assertions.assertEquals(cstr("true1"), cbol(true).add(cstr("1")));
    	Assertions.assertEquals(cstr("truey"), cbol(true).add(cstr("y")));
    }


}
