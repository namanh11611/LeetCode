package com.namanh.string

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram
 * You are given two strings of the same length s and t. In one step you can choose any character of t and replace it
 * with another character. Return the minimum number of steps to make t an anagram of s.
 *
 * S1: Because s and t only contains lowercase character, we can use an integer array countArr to store the number
 *     appearance of each character in s string.
 * S2: Iterate over all character of t string. If s contains that character, reduce the number appearance countArr[i].
 *     If countArr[i] == 0, increase result.
 *
 * Time: O(n)
 * Space: O(1)
 */
object MinimumNumberOfStepsToMakeTwoStringsAnagram {
    fun minSteps(s: String, t: String): Int {
        val countArr = IntArray(26)
        for (c in s) {
            countArr[c - 'a']++
        }
        var result = 0
        for (c in t) {
            if (countArr[c - 'a'] == 0) {
                result++
            } else {
                countArr[c - 'a']--
            }
        }
        return result
    }
}