package com.namanh.string

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 *
 * Time: O(n)
 * Space: O(1)
 */
object FindTheIndexOfTheFirstOccurrenceInAString {
    fun strStr(haystack: String, needle: String): Int {
        for (i in haystack.indices) {
            if (checkOccurrence(haystack, needle, i)) return i
        }
        return -1
    }

    private fun checkOccurrence(haystack: String, needle: String, index: Int): Boolean {
        for (i in needle.indices) {
            if (index + i >= haystack.length || haystack[index + i] != needle[i]) return false
        }
        return true
    }
}