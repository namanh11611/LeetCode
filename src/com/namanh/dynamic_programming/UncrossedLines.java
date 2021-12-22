package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/uncrossed-lines
 * You are given two integer arrays nums1 and nums2. We may draw connecting lines: a straight line connecting two
 * numbers nums1[i] and nums2[j] such that:
 * - nums1[i] == nums2[j]
 * - the line we draw does not intersect any other connecting (non-horizontal) line.
 * Return the maximum number of connecting lines we can draw in this way.
 *
 * NOTE: Similar {@link LongestCommonSubsequence}
 */
public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
