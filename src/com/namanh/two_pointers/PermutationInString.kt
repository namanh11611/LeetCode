package com.namanh.two_pointers

/**
 * https://leetcode.com/problems/permutation-in-string
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * S1: Save the frequency of characters in s1
 * S2: Use 2 pointer to iterate s1
 * S3: When meet a new character, reset frequency list and 2 pointers
 * S4: When meet an existing character with frequency > 0, reduce its frequency
 * S5: When meet an existing character with frequency = 0, increase left pointer until frequency > 0
 *
 * Time: O(m + n)
 * Space: O(1)
 */
object PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        var left = 0
        var right = 0
        val originFreqArr = IntArray(26) { -1 }
        for (c in s1) {
            if (originFreqArr[c - 'a'] < 0) {
                originFreqArr[c - 'a'] = 1
            } else {
                originFreqArr[c - 'a']++
            }
        }
        var freqArr = originFreqArr.clone()
        while (right < s2.length) {
            if (freqArr[s2[right] - 'a'] >= 0) {
                if (freqArr[s2[right] - 'a'] == 0) {
                    while (left < right && freqArr[s2[right] - 'a'] == 0) {
                        freqArr[s2[left] - 'a']++
                        left++
                    }
                }
                freqArr[s2[right] - 'a']--
                right++
                if (right - left == s1.length) return true
            } else {
                right++
                left = right
                freqArr = originFreqArr.clone()
            }
        }
        return false
    }
}