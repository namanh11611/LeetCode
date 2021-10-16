package com.namanh.prefix_sum;

/**
 * Range Sum Query - Immutable
 * https://leetcode.com/problems/range-sum-query-immutable
 */
public class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        return left == 0 ? nums[right] : nums[right] - nums[left - 1];
    }
}
