package com.namanh.math

/**
 * https://leetcode.com/problems/count-sorted-vowel-strings
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are
 * lexicographically sorted.
 */
object CountSortedVowelStrings {
    /**
     * S1: We have n slot, add 4 boundaries -> we have n + 4 slot
     * S2: Fill a, e, i, o, u -> a..a | e..e | i..i | o..o | u..u
     * S3: Result equals select 4 slots in (n + 4) slots: (n + 4)! / (n! * 4!)
     *
     * Time: O(k) with k = 5
     * Space: O(1)
     */
    fun countVowelStrings(n: Int): Int {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24
    }

    /**
     * [startByU, startByO, startByI, startByE, startByA]
     * ~~ [u, o, i, e, a]
     * -> prefix = [u, u + o, u + o + i, u + o + i + e, u + o + i + e + a]
     *
     * Time: O(n * k) with k = 5
     * Space: O(k)
     */
    fun countVowelStrings1(n: Int): Int {
        val prefix = IntArray(5) { 1 }
        for (i in 1..n) {
            for (k in 1..4) {
                prefix[k] += prefix[k - 1]
            }
        }
        return prefix[4]
    }
}