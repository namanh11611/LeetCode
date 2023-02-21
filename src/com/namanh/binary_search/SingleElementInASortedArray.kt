package com.namanh.binary_search

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
 * element which appears exactly once. Return the single element that appears only once.
 *
 *      1 1 2 2 3    4     4   5 5
 *                2i - 1 = 2i
 * S1: Return edge case when single element is first or last element
 * S2: Use binary search to find single element
 *
 * Time: O(log(n))
 * Space: O(1)
 */
object SingleElementInASortedArray {
    fun singleNonDuplicate(nums: IntArray): Int {
        val n = nums.size
        if (n == 1 || nums[0] != nums[1]) return nums[0]
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1]
        var start = 1
        var end = (n - 1) / 2
        while (start < end) {
            val mid = start + (end - start) / 2
            if (nums[2 * mid - 1] == nums[2 * mid]) {
                end = mid
            } else {
                start = mid + 1
            }
        }
        return nums[2 * start - 2]
    }
}