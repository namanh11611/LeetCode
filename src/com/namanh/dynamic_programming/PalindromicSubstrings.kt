package com.namanh.dynamic_programming

/**
 * https://leetcode.com/problems/palindromic-substrings
 * Given a string s, return the number of palindromic substrings in it.
 *
 * S1: Init result equals s length
 * S2: Iterate string, each character, check 2 case:
 *     - ...aa... -> s[i] = s[i+1]
 *     - ...aba... -> s[i-1] = s[i+1]
 *
 * Time: O(n^2)
 * Space: O(1)
 */
class PalindromicSubstrings {
    fun countSubstrings(s: String): Int {
        var result = s.length
        var j = 0
        for (i in 0 until s.length - 1) {
            j = 0
            while (isSame(s, i - j, i + 1 + j)) {
                result++
                j++
            }

            j = 0
            while (isSame(s, i - 1 - j, i + 1 + j)) {
                result++
                j++
            }
        }
        return result
    }

    fun isSame(s: String, left: Int, right: Int): Boolean {
        if (left < 0 || right >= s.length) return false
        return s[left] == s[right]
    }
}