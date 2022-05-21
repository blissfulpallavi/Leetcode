package com.pal.NegativeBase;

public class AdditionOfNegativeBaseNumbers {

    public static void main(String[] args) {
        int A = 5730;
        int B = -2396;
        String result = add(A,B,-2);

        System.out.println("Result="+result);
    }

    private static String add(int A, int B, int base) {
        String X = negativeBase(A, base);
        String Y = negativeBase(B, base);

        System.out.println("X="+X);
        System.out.println("Y="+Y);

        return binaryAdd(X,Y);
    }

    private static String binaryAdd(String x, String y) {
        while(x.length()>0 && y.length()>0){
            //x%2
        }

        return "";
    }

    public static String negativeBase(int integer, int base) {
        String result = "";
        int number = integer;
        while (number != 0) {
            int i = number % base;
            number /= base;
            if (i < 0) {
                i += Math.abs(base);
                number++;
            }
            result =  result+i;
        }
        return result;
    }
}
