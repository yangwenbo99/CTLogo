package ctlogoTest;

import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.processing.BasicTokenStream;
import ctlogo.processing.TokenStream;

public class TestProcessing {

    @Test
	void testTrival1() throws IOException {
        String testS = 
            "REPEAT 100 [ FD 10 RT 10 ]\n";
        String [] expected = new String [] {
            "REPEAT", "100", "[", "FD", "10", "RT", "10", "]", "\n"
        };

        try (BasicTokenStream ts = new BasicTokenStream(new Scanner(testS))) {
            for (String s : expected) {
                Assertions.assertEquals(s, ts.getNext());
                Assertions.assertEquals(s, ts.popNext());
            }
            Assertions.assertFalse(ts.hasNext());
            Assertions.assertFalse(ts.hasNextLine());
        }

    }

    @Test
    void testTrival2 () {
        String testS = 
            "REPEAT 100[FD 10 RT 10 ]\n";
        String [] expected = new String [] {
            "REPEAT", "100", "[", "FD", "10", "RT", "10", "]", "\n"
        };

        try (Scanner sc = new Scanner(testS)) {
            TokenStream ts = new BasicTokenStream(sc);
            for (String s : expected) {
                Assertions.assertEquals(s, ts.popNext());
            }
        }

    }

    @Test
    void testTrivalArithmetics1 () {
        String testS = 
            "REPEAT 100[FD 10+2 - 3 >> 4 % 5 RT 10 ]\n";
        String [] expected = new String [] {
            "REPEAT", "100", "[", "FD", "10", "+", "2", "-", "3", ">>", 
            "4", "%", "5", "RT", "10", "]", "\n"
        };

        try (Scanner sc = new Scanner(testS)) {
            TokenStream ts = new BasicTokenStream(sc);
            for (String s : expected) {
                Assertions.assertEquals(s, ts.popNext());
            }
            Assertions.assertFalse(ts.hasNext());
        }
    }

    @Test
    void testTrivalArithmetics2 () {
        String testS = 
        		"5 ^ 4 * (3 + 1 * var) = 7 && vv != 3\n";
        String [] expected = new String [] {
        		"5", "^", "4", "*", "(", "3", "+", "1", "*", "var", ")",
        		"=", "7", "&&", "vv", "!=", "3", "\n"
        };

        try (Scanner sc = new Scanner(testS)) {
            TokenStream ts = new BasicTokenStream(sc);
            for (String s : expected) {
                Assertions.assertEquals(s, ts.popNext());
            }
            Assertions.assertFalse(ts.hasNext());
        }
    }
    
    @Test 
    void testNagative () {
        String testS = 
        		"1 - -1 +-1 * (123 #(n))\n";
        String [] expected = new String [] {
        		"1", "-", "-", "1", "+", "-", "1", "*", "(", "123", "#", 
        		"(", "n", ")", ")", "\n"
        };

        try (Scanner sc = new Scanner(testS)) {
            TokenStream ts = new BasicTokenStream(sc);
            for (String s : expected) {
                Assertions.assertEquals(s, ts.popNext());
            }
            Assertions.assertFalse(ts.hasNext());
        }
    }

    @Test 
    void testStringTrivial1 () {
        String testS = 
        		"PR \'AAA\' + \'BBB\'";
        String [] expected = new String [] {
        		"PR", "\'AAA\'", "+", "\'BBB\'", "\n"
        };

        try (Scanner sc = new Scanner(testS)) {
            TokenStream ts = new BasicTokenStream(sc);
            for (String s : expected) {
                Assertions.assertEquals(s, ts.popNext());
            }
        }
    }

    @Test 
    void testStringTrivial2 () {
        String testS = 
        		"PR \'this is a string\' FD 1 PR \'this is a string\'";
        String [] expected = new String [] {
        		"PR", "\'this is a string\'", "FD", "1",
        		"PR", "\'this is a string\'", "\n"
        };

        try ( Scanner sc = new Scanner(testS))  {
            TokenStream ts = new BasicTokenStream(sc);
            for (String s : expected) {
                Assertions.assertEquals(s, ts.popNext());
            }
            Assertions.assertFalse(ts.hasNext());
        }
    }

    @Test 
    void testMultiLines () {
        String testS = 
        		"PR \'this is a string\' _\n FD 1 PR \'this is a string\'\n" + 
                "ABSC";
        String [] expected = new String [] {
        		"PR", "\'this is a string\'", "FD", "1",
        		"PR", "\'this is a string\'", "\n", "ABSC", "\n"
        };

        try ( Scanner sc = new Scanner(testS)) {
            TokenStream ts = new BasicTokenStream(sc);
            for (String s : expected) {
                Assertions.assertEquals(s, ts.getNext());
                Assertions.assertEquals(s, ts.popNext());
            }
            Assertions.assertFalse(ts.hasNext());
        }
    }

    @Test 
    void testPushFront () {
        String testS = 
        		"PR \'this is a string\'";
        String [] expected = new String [] {
        		"AAAA", "PR", "\'this is a string\'", "\n"
        };

        try ( Scanner sc = new Scanner(testS)) {
            TokenStream ts = new BasicTokenStream(sc);
            Assertions.assertTrue(ts.pushFront("AAAA"));
            for (String s : expected) {
                Assertions.assertEquals(s, ts.popNext());
            }
            Assertions.assertFalse(ts.hasNext());
        }
    }

    @Test 
    void testWholeLine () {
        String testS = 
        		"PR \'AAA\' + \'BBB\'";
        String [] expected = new String [] {
        		"PR", "\'AAA\'", "+", "\'BBB\'", "\n"
        };

        try (Scanner sc = new Scanner(testS)) {
            TokenStream ts = new BasicTokenStream(sc);
            Assertions.assertArrayEquals(
                    expected, 
                    ts.getNextLine().toArray(expected));
            Assertions.assertFalse(ts.hasNext());
        }
    }
    
    @Test
    void testVariable() {
        String testS = 
        		"PR 1 + :abc :m\n";
        String [] expected = new String [] {
        		"PR", "1", "+", ":abc", ":m", "\n"
        };

        try (Scanner sc = new Scanner(testS)) {
            TokenStream ts = new BasicTokenStream(sc);
            Assertions.assertArrayEquals(
                    expected, 
                    ts.getNextLine().toArray(expected));
            Assertions.assertFalse(ts.hasNext());
        }
    }

    @Test
    void testAssignment() {
        String testS = 
        		"s := 1 + :abc :m\n";
        String [] expected = new String [] {
        		"s", ":=", "1", "+", ":abc", ":m", "\n"
        };

        try (Scanner sc = new Scanner(testS)) {
            TokenStream ts = new BasicTokenStream(sc);
            Assertions.assertArrayEquals(
                    expected, 
                    ts.getNextLine().toArray(expected));
            Assertions.assertFalse(ts.hasNext());
        }
    }
}
