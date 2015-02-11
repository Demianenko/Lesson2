package com.company;

import java.util.ArrayList;
import java.util.Arrays;

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
        simpleArLi.remove(0);
        System.out.println(simpleArLi);
        simpleArLi.remove();
        System.out.println(simpleArLi);
        System.out.println(simpleArLi.contains(1));
        simpleArLi.set("ff",3);
        System.out.println(simpleArLi);
        simpleArLi.add("LL",0);
        System.out.println(simpleArLi);
    }
}
