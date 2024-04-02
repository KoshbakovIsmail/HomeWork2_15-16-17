package com.Work2151617.demo.Work21517.test;

import com.Work2151617.demo.Work21517.exception.ArrIntegerIsFullException;
import com.Work2151617.demo.Work21517.exception.InvalidIndexException;
import com.Work2151617.demo.Work21517.exception.NullItemException;
import com.Work2151617.demo.Work21517.serviceImpl.IntegerListImpl2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImpl2Test {
    private IntegerListImpl2 integerListImpl2;

    private Integer number1 = 1;
    private Integer number2 = 2;
    private Integer number3 = 3;
    private Integer number4 = 4;
    private Integer invalidNum = 56;

    @BeforeEach
    public void setUp() {
        integerListImpl2 = new IntegerListImpl2();
    }

    private IntegerListImpl2 arr1 = new IntegerListImpl2(3);
    private IntegerListImpl2 arr2 = new IntegerListImpl2(3);
    private IntegerListImpl2 arr3 = new IntegerListImpl2(3);
    private IntegerListImpl2 arrnull = null;

    @Test
    void testAddStringItem() {
        arr1.add(number1);
        arr1.add(number2);
        arr1.add(number3);
        assertEquals(number1, arr1.get(0));
        assertEquals(number3, arr1.get(2));
        assertThrows(ArrIntegerIsFullException.class, () -> arr1.add(invalidNum));
        arr1.clear();
        assertThrows(NullItemException.class, () -> arr1.add(null));
    }

    @Test
    void testAdd_intIndex_StringItem() {
        arr1.add(0, number1);
        arr1.add(1, number2);
        arr1.add(2, number3);

        assertEquals(number1, arr1.get(0));
        assertEquals(number3, arr1.get(2));

        assertThrows(ArrIntegerIsFullException.class, () -> arr1.add(invalidNum));
        arr1.clear();
        assertThrows(NullItemException.class, () -> arr1.add(null));
        assertThrows(InvalidIndexException.class, () -> arr1.add(6, number1));
    }

    @Test
    void set() {
        arr1.add(0, number1);
        arr1.add(1, number2);
        arr1.add(2, number3);

        arr1.set(0, number4);
        assertEquals(4, arr1.get(0));

        assertThrows(ArrIntegerIsFullException.class, () -> arr1.add(null));
        assertThrows(InvalidIndexException.class, () -> arr1.set(6, number1));
    }

    @Test
    void testRemoveStringItem() {
        arr1.add(0, number1);
        arr1.add(1, number2);
        arr1.add(2, number3);

        arr1.remove(number2);

        assertEquals(number3, arr1.get(1));
        assertThrows(NullItemException.class, () -> arr1.remove(null));
        assertThrows(InvalidIndexException.class, () -> arr1.remove(invalidNum));

    }

    @Test
    void testRemove_intIndex() {
        arr1.add(0, number1);
        arr1.add(1, number2);
        arr1.add(2, number3);

        arr1.remove(1);

        assertEquals(number3, arr1.get(1));

        assertThrows(InvalidIndexException.class, () -> arr1.remove(6));
    }

    @Test
    void contains() {
        arr1.add(number1);
        arr1.add(number2);
        arr1.add(number3);

        assertTrue(arr1.contains(number1));
        assertFalse(arr1.contains(invalidNum));
    }

    @Test
    void indexOf() {
        int expPositiveNum = 1;
        int expNegativeNum = -1;
        arr1.add(number1);
        arr1.add(number2);

        int actualPosNum = arr1.indexOf(number1);
        int actualNegNum = arr1.indexOf(invalidNum);

        assertEquals(expPositiveNum, actualPosNum);
        assertEquals(expNegativeNum, actualNegNum);
    }

    @Test
    void lastIndexOf() {
        int expPositiveNum = 1;
        int expNegativeNum = -1;
        arr1.add(number1);
        arr1.add(number2);

        int actualPosNum = arr1.indexOf(number1);
        int actualNegNum = arr1.indexOf(invalidNum);

        assertEquals(expPositiveNum, actualPosNum);
        assertEquals(expNegativeNum, actualNegNum);
    }

    @Test
    void get() {
        arr1.add(number1);
        arr1.add(number2);

        assertEquals(number1,arr1.get(0));
        assertEquals(number2,arr1.get(1));
        assertThrows(InvalidIndexException.class, () -> arr1.get(6));
    }

    @Test
    void testEquals() {
        arr1.add(number1);
        arr1.add(number2);
        arr2.add(number1);
        arr2.add(number2);

        assertTrue(arr1.equals(arr2));

        arr1.remove(0);
        assertFalse(arr1.equals(arr2));
    }

    @Test
    void size() {
        arr1.add(number1);
        arr1.add(number2);

        assertEquals(2, arr1.size());

        arr1.remove(0);
        assertEquals(1, arr1.size());
    }


    @Test
    void isEmpty() {
        assertTrue(arr1.isEmpty());
        arr1.add(number1);
        assertFalse(arr1.isEmpty());
        arr1.clear();
        assertTrue(arr1.isEmpty());
    }

    @Test
    void clear() {
        assertTrue(arr1.isEmpty());
        arr1.add(number1);
        arr1.add(number2);
        assertFalse(arr1.isEmpty());
        arr1.clear();
        assertTrue(arr1.isEmpty());
    }

    @Test
    void toArray() {
        arr1.add(number1);
        arr1.add(number2);

        arr2.add(number1);
        arr2.add(number2);

        assertArrayEquals(arr1.toArray(), arr2.toArray());

    }


    @Test
    public void testPrivateSortInsertion() throws Exception {
        Integer[] arr = {5, 3, 8, 2, 1};
        IntegerListImpl2 list = new IntegerListImpl2(5);

        Method sortInsertionMethod = IntegerListImpl2.class.
                getDeclaredMethod("sortInsertion", Integer[].class);
        sortInsertionMethod.setAccessible(true);
        sortInsertionMethod.invoke(list, (Object) arr);

        Integer[] expected = {1, 2, 3, 5, 8};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testPrivateBinarySearch() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        IntegerListImpl2 integerList = new IntegerListImpl2();
        Integer[] arr = {1, 3, 5, 7, 9};

        Method binarySearch = IntegerListImpl2.class.getDeclaredMethod("binarySearch", Integer[].class, Integer.class);
        binarySearch.setAccessible(true);

        assertTrue((boolean) binarySearch.invoke(integerList, arr, 5));

        assertFalse((boolean) binarySearch.invoke(integerList, arr, 4));
    }


}