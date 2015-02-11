package com.company;
public interface MyList {
    void    add(Object o);
    int     size();
    boolean isEmpty();
    Object  get(int i);
    Object    remove(int i);
    void    clear();
    boolean contains(Object o);
}
