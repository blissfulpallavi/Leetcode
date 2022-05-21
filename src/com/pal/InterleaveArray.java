package com.pal;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2-D array, read it vertically and then horizontally
 *
 * Example:
 *
 * [ 1 4 7 8 ]
 * [ 4 6 7 ]
 * [ 3 2 5 9 10 ]
 *
 * Output: [ 1, 4, 3, 4, 6, 2, 7, 7, 5, 8, 9, 10]
 *
 */
public class InterleaveArray {

    public static void main(String[] args) {
        int[][] input = {{1,4,7,8},
                        {4,6,7},
                        {3,2,5,9,10}};

        InterleaveArray ila = new InterleaveArray();
        ila.interleave(input);
    }

    private void interleave(int[][] input) {
        List<Integer> arr = new ArrayList<>();
        int j=0;
        int len = input.length;
        int maxlen =0 ;

        for(int i=0;i<len;i++){
            if(input[i].length>maxlen)
                maxlen=input[i].length;
        }

        while(j<maxlen){
            for(int i=0;i<len;i++){
                if(j<input[i].length)
                    arr.add(input[i][j]);
            }
            j++;
        }

        System.out.println(arr);
    }

}
