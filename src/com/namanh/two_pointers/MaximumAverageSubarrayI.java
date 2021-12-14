package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 *
 * S1: Calculate sum from 0 to k - 1
 * S2: Iterate from k to end, each step, add nums[i] and minus nums[i-k]
 * S3: Compare and save max sum, return max average
 *
 * Time: O(n)
 * Space: O(1)
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }

        int maxSum = curSum;
        for (int i = k; i < n; i++) {
            curSum += nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, curSum);
        }

        return (double) maxSum / k;
    }
}
