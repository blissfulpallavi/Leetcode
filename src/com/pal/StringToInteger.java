package com.pal;

public class StringToInteger {

    public static void main(String[] args){
        StringToInteger s2i = new StringToInteger();
        System.out.println("Output="+s2i.myAtoi("42"));
    }

    public int myAtoi(String s) {
        char[] chArray = s.toCharArray();
        int result=0;

        for(int i=0;i<chArray.length;i++){
            System.out.println(chArray[i]);
        }

        return result;
    }
}
