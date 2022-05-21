package com.pal;

/**
 *Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * Example 3:
 * Input: height = [4,3,2,1,4]
 * Output: 16
 */
public class MaxWaterContainer {

    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len-1;
        int area=0;

        while(left<right){
            area = Math.max(area,Math.min(height[left],height[right]) * (right-left));

            if(height[left]<height[right])
                left++;
            else
                right--;
        }

        return area;
    }

    public static void main(String[] args){
        MaxWaterContainer maxWaterContainer = new MaxWaterContainer();
        int[] input = {1,8,6,2,5,4,8,3,7};

        System.out.println("Result="+maxWaterContainer.maxArea(input));
    }

}
