package com.namanh.dynamic_programming;

import java.util.List;

/**
 * https://leetcode.com/problems/word-break
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * S1: Use dp bottom-up
 * S2: Iterate string s, each step, check if sub string end with current word
 * S3: Add dp[i- word.length] into dp[i]
 * S4: Return true if dp[n] > 0
 *
 * NOTE: Use top-down will be time limit
 *
 * Time: O(n * m)
 * Space: O(n)
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            String sub = s.substring(0, i);
            for (String word : wordDict) {
                if (sub.endsWith(word)) {
                    dp[i] += dp[i - word.length()];
                }
            }
        }
        return dp[n] > 0;
    }
}
