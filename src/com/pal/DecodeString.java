package com.pal;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        String inputStr = "3[ab2[c]]";
        String result = decode(inputStr);

        System.out.println("Decoded String="+result);
    }

    private static String decode(String inputStr) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> substr = new Stack<>();
        String res="";
        int index = 0;

        while(index<inputStr.length()){
            if(Character.isDigit(inputStr.charAt(index))){
                int count = 0;
                while(Character.isDigit(inputStr.charAt(index))){
                    count = 10 * count + Character.getNumericValue(inputStr.charAt(index));
                    index++;
                }
                counts.push(count);
            } else if(inputStr.charAt(index) == '['){
                substr.push(res);
                res = "";
                index++;
            } else if(inputStr.charAt(index) == ']'){
                StringBuilder temp  = new StringBuilder(substr.pop());
                int counter = counts.pop();
                for(int i=0;i<counter;i++)
                    temp.append(res);
                res=temp.toString();
                index++;
            } else{
                res+= inputStr.charAt(index);
                index++;
            }
        }


        return res;
    }
}
