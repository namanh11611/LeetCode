package com.namanh.running_sum_1d_array;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
