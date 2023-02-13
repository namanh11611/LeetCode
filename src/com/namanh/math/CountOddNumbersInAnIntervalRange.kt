package com.namanh.math

/**
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 *
 * Time: O(1)
 * Space: O(1)
 */
object CountOddNumbersInAnIntervalRange {
    fun countOdds(low: Int, high: Int): Int {
        val start = low - (low and 1)
        val end = high + (high and 1)
        return (end - start) shr 1
    }
}