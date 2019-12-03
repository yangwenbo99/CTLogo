/**
 * 
 */
package ctlogo.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.TypeConversionDirection;
import ctlogo.data.TypeMarker;

/**
 * @author Paul
 *
 */
public class TestTypeConversionDirection {
    TypeMarker tm1 = new TypeMarker("type marker 1");
    TypeMarker tm2 = new TypeMarker("type marker 2");
    TypeMarker tm3 = new TypeMarker("type marker 3");
    TypeConversionDirection dir1 = new TypeConversionDirection(tm1, tm2);
    TypeConversionDirection dir2 = new TypeConversionDirection(tm1, tm3);
    TypeConversionDirection dir3 = new TypeConversionDirection(tm2, tm3);
    TypeConversionDirection dir4 = new TypeConversionDirection(tm1, tm2);

    @Test 
    public void testDirEquals() {
        Assertions.assertEquals(dir2, dir2);
        Assertions.assertNotEquals(dir2, dir1);
        Assertions.assertNotEquals(dir3, dir1);
        Assertions.assertNotEquals(dir1, "aaa");
    }

    @Test
    public void testHash() {
        Assertions.assertEquals(dir1.hashCode(), dir1.hashCode());
        Assertions.assertEquals(dir1.hashCode(), dir4.hashCode());
    }

    @Test 
    public void testDirToString() {
        String s = dir1.toString();
        Assertions.assertTrue(() -> s.contains("<"));
        Assertions.assertTrue(() -> s.contains("ctlogo.data.TypeConversionDirection"));
        Assertions.assertTrue(() -> s.contains("type marker 1"));
        Assertions.assertTrue(() -> s.contains("type marker 2"));
        Assertions.assertTrue(() -> s.contains(">"));
    }

    @Test
    public void testGetFrom() {
        Assertions.assertEquals(tm1, dir1.getFrom());
    }

    public void testGetTo() {
        Assertions.assertEquals(tm2, dir1.getTo());
    }

}
