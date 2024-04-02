package com.Work2151617.demo.Work21517.serviceImpl;

import com.Work2151617.demo.Work21517.exception.ArrIntegerIsFullException;
import com.Work2151617.demo.Work21517.exception.InvalidIndexException;
import com.Work2151617.demo.Work21517.exception.NullItemException;
import com.Work2151617.demo.Work21517.service.IntegerList2;

import java.util.Arrays;

public class IntegerListImpl2 implements IntegerList2 {
    private final Integer[] arrInteger;
    private int size;

    public IntegerListImpl2() {
        arrInteger = new Integer[10];
    }

    public IntegerListImpl2(int initSize) {
        this.arrInteger = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        arrInteger[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
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
    public boolean equals(IntegerList2 otherList) {
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

    private void validateSize() {
        if (size == arrInteger.length) {
            throw new ArrIntegerIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }

    }

    private void sortInsertion(Integer[] arrInteger) {
        for (int i = 1; i < arrInteger.length; i++) {
            int temp = arrInteger[i];
            int j = i;
            while (j > 0 && arrInteger[j - 1] >= temp) {
                arrInteger[j] = arrInteger[j - 1];
                j--;
            }
            arrInteger[j] = temp;
        }
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
}
