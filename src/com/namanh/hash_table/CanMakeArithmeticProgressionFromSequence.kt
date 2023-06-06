package com.namanh.hash_table

/**
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is
 * the same. Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic
 * progression. Otherwise, return false.
 *
 * S1: Find min and max value, store all value to set
 * S2: Check distance
 * S3: Check all number in set
 *
 * Time: O(n)
 * Space: O(n)
 */
object CanMakeArithmeticProgressionFromSequence {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        val n = arr.size
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        val set = mutableSetOf<Int>()
        for (a in arr) {
            min = minOf(min, a)
            max = maxOf(max, a)
            set.add(a)
        }
        if ((max - min) % (n - 1) != 0) return false
        val distance = (max - min) / (n - 1)
        for (i in 1 until n) {
            min += distance
            if (!set.contains(min)) return false
        }
        return true
    }
}