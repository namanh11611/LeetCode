package com.namanh.hash_table

/**
 * https://leetcode.com/problems/number-of-good-pairs
 * Given an array of integers nums, return the number of good pairs.
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 * Time: O(n)
 * Space: O(n)
 */
object NumberOfGoodPairs {
    fun numIdenticalPairs(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        var count = 0
        for (n in nums) {
            val prev = map.getOrDefault(n, 0)
            count += prev
            map[n] = prev + 1
        }
        return count
    }
}