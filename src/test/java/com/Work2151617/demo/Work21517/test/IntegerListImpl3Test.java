package com.Work2151617.demo.Work21517.test;

import com.Work2151617.demo.Work21517.exception.InvalidIndexException;
import com.Work2151617.demo.Work21517.exception.NullItemException;
import com.Work2151617.demo.Work21517.serviceImpl.IntegerListImpl3;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImpl3Test {
    private IntegerListImpl3 integerListImpl3;
    private final Integer number1 = 1;
    private final Integer number2 = 2;
    private final Integer number3 = 3;
    private final Integer number4 = 4;
    private final Integer invalidNum = 45;

    public void setUp() {
        integerListImpl3 = new IntegerListImpl3();
    }

    IntegerListImpl3 arr1 = new IntegerListImpl3(3);
    IntegerListImpl3 arr2 = new IntegerListImpl3(3);
    IntegerListImpl3 arr3 = null;

    @Test
    void testAddIntegerItem() {
        arr1.add(number1);
        arr1.add(number2);
        arr1.add(number3);

        assertFalse(arr1.isEmpty());
        assertEquals(number1, arr1.get(0));
        assertEquals(3, arr1.size());

        arr1.add(number4);
        assertEquals(4, arr1.get(3));
        assertEquals(4, arr1.size());
        assertThrows(NullItemException.class, () -> arr1.add(null));
    }

    @Test
    void testAdd_IntegerIndex_IntegerItem() {
        arr1.add(0, number1);
        arr1.add(1, number2);
        arr1.add(2, number3);

        assertFalse(arr1.isEmpty());
        assertEquals(2, arr1.get(1));

        assertEquals(3, arr1.size());
        arr1.add(3, number4);
        assertEquals(4, arr1.size());

        assertThrows(NullItemException.class, () -> arr1.add(null));
        assertThrows(InvalidIndexException.class, () -> arr1.add(6, invalidNum));
    }

    @Test
    void testSet() {
        arr1.add(number1);
        arr1.add(number2);
        arr1.add(number3);

        assertEquals(2, arr1.get(1));
        arr1.set(1, number4);
        assertEquals(4, arr1.get(1));

        assertThrows(InvalidIndexException.class, () -> arr1.set(6, number3));
        assertThrows(NullItemException.class, () -> arr1.set(2, null));
    }

    @Test
    void testRemoveIntegerItem() {
        arr1.add(0, number1);
        arr1.add(1, number2);
        arr1.add(2, number3);

        arr1.remove(number2);
        assertEquals(3, arr1.get(1));
        assertThrows(NullItemException.class, () -> arr1.remove(null));
    }

    @Test
    void testRemoveIntegerIndex() {
        arr1.add(0, number1);
        arr1.add(1, number2);
        arr1.add(2, number3);

        arr1.remove(1);
        assertEquals(3, arr1.get(1));
        assertThrows(InvalidIndexException.class, () -> arr1.remove(6));
    }

    @Test
    void testContains() {
        arr1.add(1);
        arr1.add(3);
        arr1.add(2);
        assertTrue(arr1.contains(3));
        assertFalse(arr1.contains(invalidNum));
    }

    @Test
    void testIndexOf() {
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
    void testLastIndexOf() {
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
    void testGet() {
        arr1.add(number1);
        arr1.add(number2);
        arr1.add(number3);

        assertEquals(number1, arr1.get(0));
        assertEquals(number3, arr1.get(2));
        assertThrows(InvalidIndexException.class, () -> arr1.get(5));
    }

    @Test
    void testEquals() {
        arr1.add(0, number1);
        arr1.add(1, number2);
        arr1.add(2, number3);
        arr1.add(3, number4);

        arr2.add(0, number1);
        arr2.add(1, number2);
        arr2.add(2, number3);
        arr2.add(3, number4);
        assertEquals(4, arr1.size());
        assertEquals(4, arr2.size());
        assertTrue(arr1.equals(arr2));
    }

    @Test
    void testSize() {
        arr1.add(number1);
        arr1.add(number2);
        assertEquals(2, arr1.size());
        arr1.remove(1);
        assertEquals(1, arr1.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(arr1.isEmpty());
        arr1.add(number1);
        assertFalse(arr1.isEmpty());
        arr1.clear();
        assertTrue(arr1.isEmpty());
    }

    @Test
    void testClear() {
        arr1.add(number1);
        arr1.add(number2);
        arr1.add(number3);
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
    void testPrivateSortInsertion() throws Exception {
        Integer[] arr = {5, 1, 2,};
        IntegerListImpl3 listImpl3 = new IntegerListImpl3(5);

        Method sortInsertionMethod = IntegerListImpl3.class.
                getDeclaredMethod("sortInsertion", Integer[].class);
        sortInsertionMethod.setAccessible(true);
        sortInsertionMethod.invoke(listImpl3, (Object) arr);

        Integer[] expArr = {1, 2, 5};
        assertArrayEquals(expArr, arr);
    }

    @Test
    void TestPrivateBinarySearch() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        IntegerListImpl3 listImpl3 = new IntegerListImpl3();
        Integer[] arr = {1, 3, 5, 7, 9};

        Method binarySearchMethod = IntegerListImpl3.class.
                getDeclaredMethod("binarySearch", Integer[].class, Integer.class);

        binarySearchMethod.setAccessible(true);
        assertTrue((boolean) binarySearchMethod.invoke(listImpl3, arr, 5));
        assertFalse((boolean) binarySearchMethod.invoke(listImpl3, arr, 4));
    }

    @Test
    void testPrivateGrow() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        IntegerListImpl3 listImpl3 = new IntegerListImpl3();
        Integer[] arr = {1, 2, 5, 7, 10};

        Field arrIntegerField = IntegerListImpl3.class.getDeclaredField("arrInteger");
        arrIntegerField.setAccessible(true);
        arrIntegerField.set(listImpl3, arr);

        Field sizeField = IntegerListImpl3.class.getDeclaredField("size");
        sizeField.setAccessible(true);
        sizeField.set(listImpl3, arr.length);

        Method growMethod = IntegerListImpl3.class.getDeclaredMethod("grow");
        growMethod.setAccessible(true);

        growMethod.invoke(listImpl3);

        Integer[] newArr = (Integer[]) arrIntegerField.get(listImpl3);
        assertEquals(arr.length + arr.length / 2, newArr.length);

    }

    @Test
    void testPrivatetQuickSort() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        IntegerListImpl3 listImpl3 = new IntegerListImpl3();
        Integer[] arr = {3, 2, 1, 4, 5};

        Method quickSortMethod = IntegerListImpl3.class.
                getDeclaredMethod("quickSort", Integer[].class, int.class, int.class);
        quickSortMethod.setAccessible(true);
        quickSortMethod.invoke(listImpl3, arr, 0, arr.length - 1);

        Integer[] expArr = {1, 2, 3, 4, 5};
        assertArrayEquals(expArr, arr);
    }

    @Test
    void testPrivatePartition() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        IntegerListImpl3 listImpl3 = new IntegerListImpl3();
        Integer[] arr = {3, 5, 4, 8, 1};

        Method partitionMethod = IntegerListImpl3.class.
                getDeclaredMethod("partition", Integer[].class, int.class, int.class);
        partitionMethod.setAccessible(true);
        int partitionIndex = (int) partitionMethod.invoke(listImpl3, arr, 0, arr.length - 1);

        for (int i = partitionIndex + 1; i < arr.length; i++) {
            assert (arr[i] > arr[partitionIndex]);
        }
        for (int j = partitionIndex + 1; j < arr.length; j++) {
            assert (arr[j]) > arr[partitionIndex];
        }
    }

    @Test
    void testPrivateSwapElements() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        IntegerListImpl3 listImpl3 = new IntegerListImpl3();
        Integer[] arr = {1, 2};
        int index1 = 0;
        int index2 = 1;

        Method swapElements = IntegerListImpl3.class.
                getDeclaredMethod("swapElements", Integer[].class, int.class, int.class);
        swapElements.setAccessible(true);
        swapElements.invoke(listImpl3, arr, index1, index2);

        assert (arr[0] == 2 && arr[1] == 1);
    }
}