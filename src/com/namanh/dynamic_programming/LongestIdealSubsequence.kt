package com.namanh.dynamic_programming

/**
 * https://leetcode.com/problems/longest-ideal-subsequence
 * You are given a string s consisting of lowercase letters and an integer k. We call a subsequence string t ideal if
 * the absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
 * Return the length of the longest ideal string.
 *
 * S1: Use array store max length of ideal subsequence end at each character
 * S2: Each step, find maxLength of character c base on maxLength of character from c - k to c + k
 *
 * Time: O(n)
 * Space: O(1)
 */
object LongestIdealSubsequence {
    fun longestIdealString(s: String, k: Int): Int {
        val maxLength = IntArray(26)
        var result = 0
        for (c in s) {
            val index = c - 'a'
            val min = maxOf(index - k, 0)
            val max = minOf(index + k, 25)
            for (i in min..max) {
                maxLength[index] = maxOf(maxLength[index], maxLength[i])
            }
            maxLength[index]++
            result = maxOf(result, maxLength[index])
        }
        return result
    }
}
