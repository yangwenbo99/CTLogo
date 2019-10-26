package ctlogoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.execute.util.*;

public class TestLongParser {

    @Test
    void testCheck() {
        Assertions.assertEquals(true, LongParser.isParseable("0"));
        Assertions.assertEquals(true, LongParser.isParseable("0b10"));
        Assertions.assertEquals(true, LongParser.isParseable("010"));
        Assertions.assertEquals(true, LongParser.isParseable("0x10"));
        Assertions.assertEquals(true, LongParser.isParseable("0x1f"));
        Assertions.assertEquals(false, LongParser.isParseable("0b20"));
        Assertions.assertEquals(false, LongParser.isParseable("08ijml"));
    }

    @Test 
    void testParse() {
        Assertions.assertEquals(0, LongParser.parseLong("0"));
        Assertions.assertEquals(2, LongParser.parseLong("0b10"));
        Assertions.assertEquals(8, LongParser.parseLong("010"));
        Assertions.assertEquals(31, LongParser.parseLong("0x1f"));
        Assertions.assertThrows(NumberFormatException.class,
                () -> LongParser.parseLong("0b2110"));
    }

}
