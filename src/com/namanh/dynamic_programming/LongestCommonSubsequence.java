package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/longest-common-subsequence
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common
 * subsequence, return 0. For example, "ace" is a subsequence of "abcde".
 *
 * S1: Use dp with formula:
 *     - If text1[i] == text2[j] -> dp[i][j] = dp[i - 1][j - 1] + 1
 *     - Otherwise -> dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
 * S2: Return dp[length1][length2]
 *
 * NOTE: Create dp array with size [n1 + 1][n2 + 1]
 *
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
