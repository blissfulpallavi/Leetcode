package com.pal;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * n == nums.length
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 * Example:
 * --Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
 * 2 is the missing number in the range since it does not appear in nums.
 *
 * --Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
 * 8 is the missing number in the range since it does not appear in nums.
 *
 * --   Input: nums = [0]
 * Output: 1
 * Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1].
 * 1 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum =0;
        int result;

        for(int i=0;i<n;i++){
            sum = sum + i - nums[i];
        }
        result = sum + n;

        return result;

    }

    public static void main(String[] args){
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {0};
        int result = missingNumber.missingNumber(nums);
        System.out.println(result);
    }
}
