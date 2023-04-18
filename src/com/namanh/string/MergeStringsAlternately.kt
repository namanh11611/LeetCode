package com.namanh.string

/**
 * https://leetcode.com/problems/merge-strings-alternately
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with
 * word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 *
 * Time: O(m + n)
 * Space: O(1)
 */
object MergeStringsAlternately {
    fun mergeAlternately(word1: String, word2: String): String {
        val m = word1.length
        val n = word2.length
        val length = maxOf(m, n)
        var result = ""
        for (i in 0 until length) {
            if (i < m) {
                result += word1[i]
            }
            if (i < n) {
                result += word2[i]
            }
        }
        return result
    }
}