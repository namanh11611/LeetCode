package com.namanh.sum;

/**
 * Running Sum of 1D Array
 * https://leetcode.com/problems/running-sum-of-1d-array
 */
public class RunningSum {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
