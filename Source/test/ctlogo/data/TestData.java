package ctlogo.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.*;
import ctlogo.exception.CTException;

import static ctlogo.data.TestDataUtility.*;

public class TestData {
   
    @Test
    void testStupidBoolean() {
    	Assertions.assertEquals(cstr("true1"), cbol(true).add(cstr("1")));
    	Assertions.assertEquals(cstr("truey"), cbol(true).add(cstr("y")));
    }


}
