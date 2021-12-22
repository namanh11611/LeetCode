package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
 *
 * S1: Fill row 0 and column 0 with sum of character
 * S2: Use dp with formula:
 *     - If s1[i] == s2[j] -> dp[i][j] = dp[i - 1][j - 1] because we don't remove anymore
 *     - Otherwise -> dp[i][j] = Math.min(dp[i - 1][j] + s1[i], dp[i][j - 1] + s2[j]) because we remove 1 of 2 character
 * S3: Return dp[n1][n2]
 *
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i - 1);
        }
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i-1] + s2.charAt(i - 1);
        }
        for (int i = 1; i <= n1; i++) {
            int c1 = s1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                int c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int sum1 = dp[i - 1][j] + c1;
                    int sum2 = dp[i][j - 1] + c2;
                    dp[i][j] = Math.min(sum1, sum2);
                }
            }
        }
        return dp[n1][n2];
    }
}
