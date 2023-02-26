package com.namanh.string

/**
 * https://leetcode.com/contest/weekly-contest-334/problems/find-the-divisibility-array-of-a-string
 * You are given a 0-indexed string word of length n consisting of digits, and a positive integer m.
 * The divisibility array div of word is an integer array of length n such that:
 * - div[i] = 1 if the numeric value of word[0,...,i] is divisible by m, or
 * - div[i] = 0 otherwise.
 * Return the divisibility array of word.
 *
 * S1: Each step, we need to reduce current number to avoid overflow
 *
 * Time: O(n)
 * Space: O(1)
 */
object FindTheDivisibilityArrayOfAString {
    fun divisibilityArray(word: String, m: Int): IntArray {
        var curNum = 0L
        val result = IntArray(word.length)
        for (i in word.indices) {
            curNum = curNum * 10 + (word[i] - '0')
            if (curNum > m) {
                curNum %= m
            }
            if (curNum % m == 0L) {
                result[i] = 1
            }
        }
        return result
    }
}