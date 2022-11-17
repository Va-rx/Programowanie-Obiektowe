package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    Vector2d vec1 = new Vector2d(3, -1);
    Vector2d vec2 = new Vector2d(2, -4);
    Object other = new Vector2d(-1, 3);

    @Test
    void testToString() {
        assertEquals(new Vector2d(3, -8).toString(), "(3, -8)");
        assertEquals(new Vector2d(0, 0).toString(), "(0, 0)");
    }

    @Test
    void testPrecedes() {
        assertTrue(new Vector2d(3, -2).precedes(new Vector2d(3, -1)));
        assertTrue(new Vector2d(3, -2).precedes(new Vector2d(3, -2)));
        assertFalse(new Vector2d(3, -2).precedes(new Vector2d(3, -3)));
    }

    @Test
    void testFollows() {
        assertFalse(new Vector2d(3, -2).follows(new Vector2d(3, -1)));
        assertFalse(new Vector2d(3, -2).follows(new Vector2d(3, -1)));
        assertTrue(new Vector2d(3, -2).follows(new Vector2d(3, -31)));
    }

    @Test
    void testAdd() {
        assertEquals(new Vector2d(3, -3).add(new Vector2d(-3, 5)), new Vector2d(0, 2));
        assertEquals(new Vector2d(7, -3).add(new Vector2d(0, -3)), new Vector2d(7, -6));
    }

    @Test
    void subtract() {
        assertEquals(new Vector2d(3, -3).subtract(new Vector2d(-3, 5)), new Vector2d(6, -8));
        assertEquals(new Vector2d(7, -3).subtract(new Vector2d(0, -3)), new Vector2d(7, 0));
    }

    @Test
    void upperRight() {
        assertEquals(new Vector2d(3, -3).upperRight(new Vector2d(-3, 5)), new Vector2d(3, 5));
        assertEquals(new Vector2d(7, -3).upperRight(new Vector2d(0, -3)), new Vector2d(7, -3));
    }

    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(3, -3).lowerLeft(new Vector2d(-3, 5)), new Vector2d(-3, -3));
        assertEquals(new Vector2d(7, -3).lowerLeft(new Vector2d(0, -3)), new Vector2d(0, -3));
    }

    @Test
    void opposite() {
        assertEquals(new Vector2d(3, -3).opposite(), new Vector2d(-3, 3));
        assertEquals(new Vector2d(7, -3).opposite(), new Vector2d(-7, 3));
    }

    @Test
    void testEquals() {
        Object obj = new Vector2d(3, -2);
        assertEquals(new Vector2d(3, -2), obj);
    }
}
