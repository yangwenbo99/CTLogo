package ctlogo.data;

import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cstr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestData {
   
    @Test
    void testStupidBoolean() {
    	Assertions.assertEquals(cstr("true1"), cbol(true).add(cstr("1")));
    	Assertions.assertEquals(cstr("truey"), cbol(true).add(cstr("y")));
    }


}
