package com.namanh.sum;

/**
 * https://leetcode.com/problems/maximum-subarray
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = maxEndingHere < 0 ? nums[i] : maxEndingHere + nums[i];
            if (maxEndingHere > result) {
                result = maxEndingHere;
            }
        }
        return result;
    }
}
