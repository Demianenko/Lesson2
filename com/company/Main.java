package com.company;

public class Main {

    public static void main(String[] args) {
        MyArrayList simpleArLi = new MyArrayList();
        System.out.println(simpleArLi);
        for(int i = 0; i < 14; i++) {
            simpleArLi.add(i);
        }
        System.out.println(simpleArLi);
        simpleArLi.add("a");
        System.out.println(simpleArLi);
        System.out.println(simpleArLi.remove(0));
        System.out.println(simpleArLi);
        simpleArLi.remove();
        System.out.println(simpleArLi);
        System.out.println(simpleArLi.contains(1));
        simpleArLi.put(3, "FF");
        System.out.println(simpleArLi);
        simpleArLi.insert(0,"hh");
        System.out.println(simpleArLi);
    }
}
