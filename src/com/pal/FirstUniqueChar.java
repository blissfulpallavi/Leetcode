package com.pal;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 */
class FirstUniqueChar {

    public static void main(String args[]) {
        FirstUniqueChar s = new FirstUniqueChar();
        System.out.println("First unique character="+s.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {

        char[] charArr = s.toCharArray();
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        int index = -1;

        for (int i = 0; i < charArr.length; i++) {
            if(map.containsKey(charArr[i])){
                map.replace(charArr[i],-1);
            }else{
                map.put(charArr[i],i);
            }
        }

        for(Map.Entry entry:map.entrySet()){
            int val = (Integer) entry.getValue();
            if(val>-1) {
                index = val;
                break;
            }
        }

        return index;
    }
}