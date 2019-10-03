package ctlogoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

import ctlogo.processing.*;

public class TestProcessing {

    @Test
    void testTrival () {
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

}
