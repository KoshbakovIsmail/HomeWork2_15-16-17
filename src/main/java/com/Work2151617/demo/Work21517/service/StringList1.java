package com.Work2151617.demo.Work21517.service;

public interface StringList1 {
    String add(String item);

    String add(int index, String item);

    String set(int index, String item);

    String remove(String item);

    String remove(int index);

    boolean contains(String item);

    int indexOf(String item);

    int lastIndexOf(String item);

    String get(int index);

    boolean equals(StringList1 otherList);

    int size();

    boolean isEmpty();

    void clear();

    String[] toArray();
}
