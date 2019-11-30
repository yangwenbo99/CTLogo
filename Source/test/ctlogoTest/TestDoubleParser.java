package ctlogoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.execute.util.DoubleParser;

public class TestDoubleParser {

    @Test
    void testCheck() {
        Assertions.assertEquals(true, DoubleParser.isParseable("0"));
        Assertions.assertEquals(true, DoubleParser.isParseable("10"));
        Assertions.assertEquals(true, DoubleParser.isParseable("010"));
        Assertions.assertEquals(true, DoubleParser.isParseable("1."));
        Assertions.assertEquals(true, DoubleParser.isParseable("1.1"));
        Assertions.assertEquals(true, DoubleParser.isParseable("1.1f"));
        Assertions.assertEquals(false, DoubleParser.isParseable("0x1f"));
        Assertions.assertEquals(false, DoubleParser.isParseable("0b20"));
        Assertions.assertEquals(false, DoubleParser.isParseable("08ijml"));
    }

    @Test 
    void testParse() {
        Assertions.assertEquals(0.1, DoubleParser.ParseDouble("0.1"));
        Assertions.assertThrows(NumberFormatException.class,
                () -> DoubleParser.ParseDouble("0b2110"));
    }

}
