package com.namanh.two_pointers

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer
 * in any order.
 *
 * S1: Save the frequency of characters in p
 * S2: Use 2 pointer to iterate s
 * S3: When meet a new character, reset frequency list and 2 pointers
 * S4: When meet an existing character with frequency > 0, reduce its frequency
 * S5: When meet an existing character with frequency = 0, increase left pointer until frequency > 0
 * S6: When meet a satisfied case, increase left pointer
 *
 * Time: O(m + n)
 * Space: O(n)
 */
object FindAllAnagramsInAString {
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        var left = 0
        var right = 0
        val originFreqArr = IntArray(26) { -1 }
        for (c in p) {
            if (originFreqArr[c - 'a'] < 0) {
                originFreqArr[c - 'a'] = 1
            } else {
                originFreqArr[c - 'a']++
            }
        }
        var freqArr = originFreqArr.clone()
        while (right < s.length) {
            if (freqArr[s[right] - 'a'] >= 0) {
                if (freqArr[s[right] - 'a'] == 0) {
                    while (left < right && freqArr[s[right] - 'a'] == 0) {
                        freqArr[s[left] - 'a']++
                        left++
                    }
                }
                freqArr[s[right] - 'a']--
                right++
                if (right - left == p.length) {
                    result.add(left)
                    freqArr[s[left] - 'a']++
                    left++
                }
            } else {
                right++
                left = right
                freqArr = originFreqArr.clone()
            }
        }
        return result
    }
}