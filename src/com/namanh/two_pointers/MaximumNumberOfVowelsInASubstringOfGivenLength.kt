package com.namanh.two_pointers

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 * S1: Use sliding window
 *
 * Time: O(n)
 * Space: O(1)
 */
object MaximumNumberOfVowelsInASubstringOfGivenLength {
    fun maxVowels(s: String, k: Int): Int {
        val n = s.length
        val vowelSet = setOf('a', 'e', 'i', 'o', 'u')
        var numVowel = 0
        for (i in 0 until k) {
            if (vowelSet.contains(s[i])) {
                numVowel++
            }
        }
        var result = numVowel
        for (i in k until n) {
            if (vowelSet.contains(s[i])) {
                numVowel++
            }
            if (vowelSet.contains(s[i - k])) {
                numVowel--
            }
            result = maxOf(result, numVowel)
        }
        return result
    }
}