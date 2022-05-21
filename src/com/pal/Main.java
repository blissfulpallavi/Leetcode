package com.pal;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("negative base:"+negativeBase(5730,-2));
    }

    public static String negativeBase(int integer, int base) {
        List<Integer> ll = new ArrayList<>();
        ll.add(34);
        ll.add(48);
        ll.add(52);

        if(ll.contains(52)){
            System.out.println("Hi! I am alive..");
        }

        String result = "";
        int number = integer;
        while (number != 0) {
            int i = number % base;
            number /= base;
            if (i < 0) {
                i += Math.abs(base);
                number++;
            }
            result = i + result;
        }
        return result;
    }
}
