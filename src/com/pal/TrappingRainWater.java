package com.pal;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Example 1:
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class TrappingRainWater {

    public int trap(int[] arr) {
        int len = arr.length;
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)

                    // update max in left
                    left_max = arr[lo];
                else

                    // water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            } else {
                if (arr[hi] > right_max)

                    // update right maximum
                    right_max = arr[hi];

                else
                    result += right_max - arr[hi];
                hi--;
            }
        }

        return result;
    }

    public static void main(String[] str){
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trw = new TrappingRainWater();
        System.out.println("Amount of rain water trapped="+trw.trap(input));
    }
}
