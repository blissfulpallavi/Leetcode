package com.pal;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println("result="+ri.reverse(-2147483648));
    }

    private int reverse(int input) {
        String str = "";
        if(input<0) {
            str = input+"";
            str = revStr(str.substring(1));
        }
        else
            str = revStr(input+"");

        double result=0d;

        if(input<0)
            result = -Double.parseDouble(str);
        else
            result = Double.parseDouble(str);

        if(Integer.MIN_VALUE<result && result<Integer.MAX_VALUE-1){
            return (int)result;
        }else
            return 0;
    }

    private String revStr(String input) {
        String str="";
        for(int i=input.length()-1;i>=0;i--){
            str+= input.charAt(i);
        }

        return str;
    }
}
