package com.namanh.dynamic_programming

/**
 * https://leetcode.com/problems/scramble-string
 * We can scramble a string s to get a string t using the following algorithm:
 * If the length of the string is 1, stop.
 * If the length of the string is > 1, do the following:
 * - Split the string into two non-empty substrings at a random index.
 * - Randomly decide to swap the two substrings or to keep them in the same order.
 * - Apply step 1 recursively on each of the two substrings x and y.
 * Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1.
 *
 * Time: O(n^4)
 * Space: O(n^3)
 */
object ScrambleString {
    fun isScramble(s1: String, s2: String): Boolean {
        val n = s1.length
        val dp = Array(n + 1) {
            Array(n) {
                BooleanArray(n)
            }
        }
        for (i in s1.indices) {
            for (j in s2.indices) {
                dp[1][i][j] = s1[i] == s2[j]
            }
        }
        for (length in 2..n) {
            for (i in 0 until n + 1 - length) {
                for (j in 0 until n + 1 - length) {
                    for (newLength in 1 until length) {
                        val dp1 = dp[newLength][i]
                        val dp2 = dp[length - newLength][i + newLength]
                        dp[length][i][j] = dp[length][i][j] or (dp1[j] && dp2[j + newLength])
                        dp[length][i][j] = dp[length][i][j] or (dp1[j + length - newLength] && dp2[j])
                    }
                }
            }
        }
        return dp[n][0][0]
    }
}