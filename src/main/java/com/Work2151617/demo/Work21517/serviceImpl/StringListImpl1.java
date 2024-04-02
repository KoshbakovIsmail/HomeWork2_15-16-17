package com.Work2151617.demo.Work21517.serviceImpl;

import com.Work2151617.demo.Work21517.exception.ArrStringIsFullException;
import com.Work2151617.demo.Work21517.exception.InvalidIndexException;
import com.Work2151617.demo.Work21517.exception.NullArrayCannotException;
import com.Work2151617.demo.Work21517.exception.NullItemException;
import com.Work2151617.demo.Work21517.service.StringList1;

import java.util.Arrays;

public class StringListImpl1 implements StringList1 {
    private final String[] arrString;
    private int size;

    public StringListImpl1() {
        arrString = new String[10];
    }

    public StringListImpl1(int initSize) {
        this.arrString = new String[initSize];
    }

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        arrString[size++] = item;
        return item;
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            arrString[size++] = item;
            return item;
        }
        System.arraycopy(arrString, index, arrString, index + 1, size - index);
        arrString[index] = item;
        size++;
        return item;
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        arrString[index] = item;
        return item;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public String remove(String item) {
        validateItem(item);

        int index = indexOf(item);

        return remove(index);
        /*if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index != size) {
            System.arraycopy(arrString,index+1,arrString, index,size- index);
        }
        size--;
        return item;*/
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public String remove(int index) {
        validateIndex(index);

        String item = arrString[index];
        if (index != size) {
            System.arraycopy(arrString, index + 1, arrString, index, size - index - 1);
        }
        size--;
        return item;
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (arrString[i].equals(item)) {
                return 1;
            }
        }
        return -1;
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrString[i].equals(item)) {
                return 1;
            }
        }
        return -1;
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    @Override
    public String get(int index) {
        validateIndex(index);
        return arrString[index];
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    @Override
    public boolean equals(StringList1 otherList) {
        validateNull(otherList);
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    // Вернуть фактическое количество элементов.
    @Override
    public int size() {
        return size;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Удалить все элементы из списка.
    @Override
    public void clear() {
        size = 0;
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    @Override
    public String[] toArray() {
        return Arrays.copyOf(arrString, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == arrString.length) {
            throw new ArrStringIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private void validateNull(StringList1 otherList) {
        if (otherList == null) {
            throw new NullArrayCannotException();
        }
    }

}
