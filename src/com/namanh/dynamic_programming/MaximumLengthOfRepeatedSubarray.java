package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 *
 * S1: Use dp with formula: nums1[i] == nums2[j] -> dp[i][j] = dp[i - 1][j - 1] + 1
 * S2: Update max length
 *
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
