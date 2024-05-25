package com.namanh.dynamic_programming

/**
 * https://leetcode.com/problems/word-break-ii
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all such possible sentences in any order.
 *
 * S1: Use dynamic programming bottom up
 * S2: Iterate string s, each step, check if sub string equal or end with current word
 *
 *  Time: O(2 ^ n)
 *  Space: O(n * m)
 */
object WordBreakII {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val dp = Array(s.length) { mutableListOf<String>() }
        for (i in s.indices) {
            val sub = s.substring(0, i + 1)
            for (word in wordDict) {
                if (sub == word) {
                    dp[i].add(word)
                } else if (sub.endsWith(word)) {
                    for (sentence in dp[i - word.length]) {
                        dp[i].add("$sentence $word")
                    }
                }
            }
        }
        return dp.last()
    }
}
