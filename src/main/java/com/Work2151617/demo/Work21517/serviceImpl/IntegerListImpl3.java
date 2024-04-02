package com.Work2151617.demo.Work21517.serviceImpl;

import com.Work2151617.demo.Work21517.exception.InvalidIndexException;
import com.Work2151617.demo.Work21517.exception.NullItemException;
import com.Work2151617.demo.Work21517.service.IntegerList3;

import java.util.Arrays;

public class IntegerListImpl3 implements IntegerList3 {
    private Integer[] arrInteger;
    private int size;

    public IntegerListImpl3() {
        arrInteger = new Integer[10];
    }

    public IntegerListImpl3(int initSize) {
        this.arrInteger = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        growIfNeeded();
        validateItem(item);
        arrInteger[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        growIfNeeded();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            arrInteger[size++] = item;
            return item;
        }
        System.arraycopy(arrInteger, index, arrInteger, index + 1, size - index);
        arrInteger[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        arrInteger[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);

        return remove(index);

    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);

        Integer item = arrInteger[index];
        if (index != size) {
            System.arraycopy(arrInteger, index + 1, arrInteger, index, size - index -1);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] arrIntegerCopy = toArray();
        sortInsertion(arrIntegerCopy);
        return binarySearch(arrIntegerCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (arrInteger[i].equals(item)) {
                return 1;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrInteger[i].equals(item)) {
                return 1;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return arrInteger[index];
    }

    @Override
    public boolean equals(IntegerList3 otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(arrInteger, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void growIfNeeded() {
        if (size == arrInteger.length) {
            grow();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }

    }

    private void sortInsertion(Integer[] arrInteger) {
        quickSort(arrInteger, 0, arrInteger.length - 1);
    }

    private boolean binarySearch(Integer[] arrInteger, Integer item) {
        int min = 0;
        int max = arrInteger.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (item == arrInteger[mid]) {
                return true;
            }
            if (item < arrInteger[mid]) {
                max = mid - 1;
            }else{
                min = mid + 1;
            }

        }
        return false;
    }

    private void grow() {
        arrInteger = Arrays.copyOf(arrInteger, size + size / 2);

    }

    private void quickSort(Integer[] arrInteger, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arrInteger, start, end);
        quickSort(arrInteger, start, partitionIndex - 1);
        quickSort(arrInteger, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arrInteger, int start, int end) {
        int pivot = arrInteger[end];
        int i = (start - 1);
        for (int j = start; j < end; j++) {
            if (arrInteger[j] <= pivot) {
                i++;
                swapElements(arrInteger, i, j);
            }
        }
        swapElements(arrInteger, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arrInteger, int i1, int i2) {
        int temp = arrInteger[i1];
        arrInteger[i1] = arrInteger[i2];
        arrInteger[i2] = temp;
    }
}
