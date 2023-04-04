package com.namanh.string

/**
 * https://leetcode.com/problems/optimal-partition-of-string
 * Given a string s, partition the string into one or more substrings such that the characters in each substring are
 * unique. That is, no letter appears in a single substring more than once.
 * Return the minimum number of substrings in such a partition.
 */
object OptimalPartitionOfString {
    /**
     * Array of last position
     * Time: O(n)
     * Space: O(1)
     */
    fun partitionString1(s: String): Int {
        val lastPosition = IntArray(26) { -1 }
        var startSubstring = 0
        var count = 1
        for (i in s.indices) {
            if (lastPosition[s[i] - 'a'] >= startSubstring) {
                startSubstring = i
                count++
            }
            lastPosition[s[i] - 'a'] = i
        }
        return count
    }

    /**
     * Set
     * Time: O(n)
     * Space: O(n)
     */
    fun partitionString2(s: String): Int {
        val set = mutableSetOf<Char>()
        var count = 1
        for (c in s) {
            if (set.contains(c)) {
                set.clear()
                count++
            }
            set.add(c)
        }
        return count
    }
}