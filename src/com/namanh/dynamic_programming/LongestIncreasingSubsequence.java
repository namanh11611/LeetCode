package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * S1: Create maxLen array to store max length of subsequence end at index i
 * S2: Formula: nums[k] < nums[i] && maxLen[k] + 1 > maxLen[i] -> update maxLen[i]
 * S3: Then, find max value in maxLen array
 *
 * Time: O(n^2)
 * Space: O(n)
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int result = 1;
        int[] maxLen = new int[n];
        maxLen[0] = 1;
        for (int i = 1; i < n; i++) {
            maxLen[i] = 1;
            for (int k = 0; k < i; k++) {
                if (nums[k] < nums[i] && maxLen[k] + 1 > maxLen[i]) {
                    maxLen[i] = maxLen[k] + 1;
                }
            }
        }
        for (int len : maxLen) {
            result = Math.max(result, len);
        }
        return result;
    }
}
