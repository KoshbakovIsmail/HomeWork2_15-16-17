package com.Work2151617.demo.Work21517.test;

import com.Work2151617.demo.Work21517.exception.ArrStringIsFullException;
import com.Work2151617.demo.Work21517.exception.InvalidIndexException;
import com.Work2151617.demo.Work21517.exception.NullArrayCannotException;
import com.Work2151617.demo.Work21517.exception.NullItemException;
import com.Work2151617.demo.Work21517.serviceImpl.StringListImpl1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImpl1Test {
    private StringListImpl1 stringListImpl1;
    private String apple = "Apple";
    private String banan = "Banan";
    private String cherry = "cherry";
    private String kiwi = "Kiwi";
    private String invalidStr = "AAA";

    @BeforeEach
    public void setUp() {
        stringListImpl1 = new StringListImpl1(3);
    }

    private StringListImpl1 stringList = new StringListImpl1(3);
    private StringListImpl1 stringlist2 = new StringListImpl1(3);
    private StringListImpl1 listNull = null;

    @Test
    void testAddStringItem() {

        stringList.add(apple);
        stringList.add(banan);
        stringList.add(cherry);

        assertEquals(apple, stringList.get(0));
        assertEquals(cherry, stringList.get(2));

        assertThrows(ArrStringIsFullException.class, () -> stringList.add(invalidStr));
        stringList.clear();
        assertThrows(NullItemException.class, () -> stringList.add(null));
    }

    @Test
    void testAdd_intIndexStringItem() {
        stringList.add(0, apple);
        stringList.add(1, banan);
        stringList.add(2, cherry);

        assertEquals(banan, stringList.get(1));
        assertEquals(cherry, stringList.get(2));
        assertThrows(ArrStringIsFullException.class, () -> stringList.add(invalidStr));
        stringList.clear();
        assertThrows(NullItemException.class, () -> stringList.add(null));
        assertThrows(InvalidIndexException.class, () -> stringList.add(6, apple));
    }

    @Test
    void set() {
        stringList.add(apple);
        stringList.add(banan);
        stringList.set(0, invalidStr);
        assertEquals(invalidStr, stringList.get(0));

        assertThrows(NullItemException.class, () -> stringList.add(null));
        assertThrows(InvalidIndexException.class, () -> stringList.set(6, apple));
    }

    @Test
    void testRemoveStringItem() {
        stringList.add(apple);
        stringList.add(banan);
        stringList.add(cherry);

        stringList.remove(banan);

        assertEquals(cherry, stringList.get(1));
        assertThrows(NullItemException.class, () -> stringList.add(null));
        assertThrows(InvalidIndexException.class, () -> stringList.remove(invalidStr));
    }

    @Test
    void testRemove_intItemStringItem() {
        stringList.add(apple);
        stringList.add(banan);
        stringList.add(cherry);

        stringList.remove(1);

        String actual = stringList.get(1);

        assertEquals(cherry, actual);
        assertThrows(InvalidIndexException.class, () -> stringList.remove(6));
    }

    @Test
    void contains() {
        stringList.add(apple);
        stringList.add(banan);
        stringList.add(cherry);

        boolean trueResult = stringList.contains(apple);
        boolean falseResult = stringList.contains(invalidStr);

        assertTrue(trueResult, apple);
        assertFalse(falseResult, invalidStr);
    }

    @Test
    void indexOf() {
        int expPositiveNum = 1;
        int expNegativeNum = -1;
        stringList.add(apple);
        stringList.add(banan);

        int actualPosNum = stringList.indexOf(apple);
        int actualNegNum = stringList.indexOf(invalidStr);

        assertEquals(expPositiveNum, actualPosNum);
        assertEquals(expNegativeNum, actualNegNum);
    }

    @Test
    void lastIndexOf() {
        int expPositiveNum = 1;
        int expNegativeNum = -1;
        stringList.add(apple);
        stringList.add(banan);

        int actualPosNum = stringList.indexOf(apple);
        int actualNegNum = stringList.indexOf(invalidStr);

        assertEquals(expPositiveNum, actualPosNum);
        assertEquals(expNegativeNum, actualNegNum);
    }

    @Test
    void get() {
        stringList.add(apple);
        stringList.add(banan);

        assertEquals(apple,stringList.get(0));
        assertEquals(banan,stringList.get(1));
        assertThrows(InvalidIndexException.class, () -> stringList.get(6));
    }

    @Test
    void testEquals() {
        stringList.add(apple);
        stringList.add(banan);

        stringlist2.add(apple);
        stringlist2.add(banan);

        assertTrue(stringList.equals(stringlist2));

        stringlist2.remove(banan);
        assertFalse(stringList.equals(stringlist2));

        assertThrows(NullArrayCannotException.class, () -> stringList.equals(listNull));
    }

    @Test
    void size() {
        stringList.add(apple);
        stringList.add(banan);
        stringList.add(cherry);

        assertEquals(3,stringList.size());

        stringList.remove(apple);
        assertEquals(2,stringList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(stringList.isEmpty());
        stringList.add(apple);
        assertFalse(stringList.isEmpty());
        stringList.remove(apple);
        assertTrue(stringList.isEmpty());
    }

    @Test
    void clear() {
        stringList.add(apple);
        stringList.add(banan);
        assertFalse(stringList.isEmpty());

        stringList.clear();

        assertTrue(stringList.isEmpty());
    }

    @Test
    void toArray() {
        stringList.add(apple);
        stringList.add(banan);

        stringlist2.add(apple);
        stringlist2.add(banan);

        assertArrayEquals(stringList.toArray(), stringlist2.toArray());
    }
}