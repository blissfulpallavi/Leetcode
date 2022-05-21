package com.pal;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *  Example:
 *  Input: nums = [2,7,11,15], target = 9
 *  Output: [0,1]
 *  Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args){
        int[] input = {3,3};
        int target = 6;
        TwoSum ts = new TwoSum();
        System.out.println("Output="+ts.twoSum(input,target));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int left;
        for(int i=0;i<nums.length;i++){
            left = target - nums[i];
            for(int j=0;j<nums.length;j++){
                if(i==j)
                    continue;
                if(left==nums[j]){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }

        return result;
    }
}
