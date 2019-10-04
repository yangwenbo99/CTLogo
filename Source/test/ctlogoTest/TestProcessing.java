package ctlogoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

import ctlogo.processing.*;

public class TestProcessing {

    @Test
    void testTrival1 () {
        String testS = 
            "REPEAT 100 [ FD 10 RT 10 ]\n";
        String [] expected = new String [] {
            "REPEAT", "100", "[", "FD", "10", "RT", "10", "]", "\n"
        };

        Scanner sc = new Scanner(testS);
        TokenStream ts = new BasicTokenStream(sc);
        for (String s : expected) {
            Assertions.assertEquals(s, ts.popNext());
        }

    }

    @Test
    void testTrival2 () {
        String testS = 
            "REPEAT 100[FD 10 RT 10 ]\n";
        String [] expected = new String [] {
            "REPEAT", "100", "[", "FD", "10", "RT", "10", "]", "\n"
        };

        Scanner sc = new Scanner(testS);
        TokenStream ts = new BasicTokenStream(sc);
        for (String s : expected) {
            Assertions.assertEquals(s, ts.popNext());
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

        Scanner sc = new Scanner(testS);
        TokenStream ts = new BasicTokenStream(sc);
        for (String s : expected) {
            Assertions.assertEquals(s, ts.popNext());
        }
        Assertions.assertFalse(ts.hasNext());
    }

    @Test
    void testTrivalArithmetics2 () {
        String testS = 
        		"5 ^ 4 * (3 + 1 * var) = 7 && vv != 3\n";
        String [] expected = new String [] {
        		"5", "^", "4", "*", "(", "3", "+", "1", "*", "var", ")",
        		"=", "7", "&&", "vv", "!=", "3", "\n"
        };

        Scanner sc = new Scanner(testS);
        TokenStream ts = new BasicTokenStream(sc);
        for (String s : expected) {
            Assertions.assertEquals(s, ts.popNext());
        }
        Assertions.assertFalse(ts.hasNext());
    }
    
    @Test 
    void testNagative () {
        String testS = 
        		"1 - -1 +-1 * (123 #(n))\n";
        String [] expected = new String [] {
        		"1", "-", "-", "1", "+", "-", "1", "*", "(", "123", "#", 
        		"(", "n", ")", ")", "\n"
        };

        Scanner sc = new Scanner(testS);
        TokenStream ts = new BasicTokenStream(sc);
        for (String s : expected) {
            Assertions.assertEquals(s, ts.popNext());
        }
        Assertions.assertFalse(ts.hasNext());
    }

    @Test 
    void testStringTrivial1 () {
        String testS = 
        		"PR \"AAA\" + \"BBB\"";
        String [] expected = new String [] {
        		"PR", "\"AAA\"", "+", "\"BBB\"", "\n"
        };

        Scanner sc = new Scanner(testS);
        TokenStream ts = new BasicTokenStream(sc);
        for (String s : expected) {
            Assertions.assertEquals(s, ts.popNext());
        }
        Assertions.assertFalse(ts.hasNext());
    }

    @Test 
    void testStringTrivial2 () {
        String testS = 
        		"PR \"this is a string\" FD 1 PR \"this is a string\"";
        String [] expected = new String [] {
        		"PR", "\"this is a string\"", "FD", "1",
        		"PR", "\"this is a string\"", "\n"
        };

        Scanner sc = new Scanner(testS);
        TokenStream ts = new BasicTokenStream(sc);
        for (String s : expected) {
            Assertions.assertEquals(s, ts.popNext());
        }
        Assertions.assertFalse(ts.hasNext());
    }
}
