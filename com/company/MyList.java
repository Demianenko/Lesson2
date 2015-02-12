package com.company;
public interface MyList {
    void    add(Object o);
    int     size();
    boolean isEmpty();
    Object  get(int i);
    Object  remove(int i);
    void    clear();
    boolean contains(Object o);
    void put(int i, Object o);
    int indexOf(Object o);
    int insert(int i, Object o);
}



