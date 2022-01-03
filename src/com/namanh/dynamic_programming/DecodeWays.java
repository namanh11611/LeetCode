package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/decode-ways
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * S1: Use dp bottom-up
 * S2: Assign value for dp[0] and dp[1]
 * S3: Iterate from i = 2, first handle for case char = 0
 * S4: dp[i] = dp[i-1], add dp[i-2] if needed
 * S5: Return dp[n]
 *
 * Time: O(n)
 * Space: O(n)
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (c == '0') {
                if (s.charAt(i - 2) < '1' || s.charAt(i - 2) > '2') return 0;
                dp[i] += dp[i - 2];
            } else {
                char c1 = s.charAt(i - 1);
                char c2 = s.charAt(i - 2);
                dp[i] += dp[i - 1];
                if (c2 == '1' || (c2 == '2' && c1 <= '6')) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}
