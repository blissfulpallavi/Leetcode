package com.pal;

import java.util.HashSet;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 */
public class LongestSubstring {

    public static void main(String[] args){
        LongestSubstring ts = new LongestSubstring();
        System.out.println("Output="+ts.lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty())
            return 0;

        if(s.length()==1)
            return 1;

        HashSet<Character> set = new HashSet<>();
        char[] chArray = s.toCharArray();
        int startIndex=0;
        int endIndex=s.length()-1;
        int maxSize=0;

        for(int i=0;i<chArray.length;i++){
            startIndex=i;
            for(int j=i;j<chArray.length;j++){
                endIndex=j;
                if(!set.contains(chArray[j])){
                    set.add(chArray[j]);
                }else{
                    set.clear();
                    endIndex--;
                    break;
                }
            }
            String subStr = s.substring(startIndex,endIndex+1);
            if(subStr.length()>maxSize)
                maxSize=subStr.length();
        }

        return maxSize;
    }
}
