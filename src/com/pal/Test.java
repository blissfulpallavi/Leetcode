package com.pal;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(9);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(4);
        set.add(1);
        set.add(5);
        set.add(7);

        List<Integer> ll = new ArrayList<>(set);

        List<Integer> ll1 = ll.stream().sorted().collect(Collectors.toList());

        //System.out.println(ll1);

        List<Integer> pal = null;

        for(int i:pal){
            System.out.println("i am ok!");
        }


    }
}
