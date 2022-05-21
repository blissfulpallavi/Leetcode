package com.pal;

import java.util.HashMap;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 *
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {
    static HashMap<Character,Integer> map = new HashMap();

    public int romanToInt(String s) {
        if(s.isEmpty() || s.isBlank())
            return -1;

        int len = s.length();

        if(len>15)
            return -1;

        int result = 0;

        for(int i=len-1;i>=0;){
            int j=i-1;
            result = result + map.get(s.charAt(i));
            while(j>=0 && map.get(s.charAt(j))<map.get(s.charAt(i))){
                result = result-map.get(s.charAt(j));
                j--;
            }
            i=j;
        }

        return result;
    }


    public static void main(String args[]){
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III"));
    }
}
