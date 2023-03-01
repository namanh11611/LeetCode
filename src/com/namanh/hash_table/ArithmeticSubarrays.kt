package com.namanh.hash_table

/**
 * https://leetcode.com/problems/arithmetic-subarrays
 * A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every
 * two consecutive elements is the same. You are given an array of n integers, nums, and two arrays of m integers each,
 * l and r, representing the m range queries, where the ith query is the range [l[i], r[i]].
 * Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]]...nums[r[i]] can be
 * rearranged to form an arithmetic sequence, and false otherwise.
 *
 * S1: Each query, we find max and min value, using set to store all elements
 * S2: Calculate distance between 2 adjacent elements
 * S3: Return true is set contains all element from min to max
 *
 * Time: O(m * n)
 * Space: O(n)
 */
object ArithmeticSubarrays {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val res = mutableListOf<Boolean>()
        for (i in l.indices) {
            res.add(isArithmeticSubarrays(nums, l[i], r[i]))
        }
        return res
    }

    private fun isArithmeticSubarrays(nums: IntArray, start: Int, end: Int): Boolean {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        val set = HashSet<Int>()
        for (j in start..end) {
            min = minOf(min, nums[j])
            max = maxOf(max, nums[j])
            set.add(nums[j])
        }
        val length = end - start
        if ((max - min) % length != 0) return false
        val distance = (max - min) / length
        for (k in 1..length) {
            if (!set.contains(min + distance * k)) return false
        }
        return true
    }
}