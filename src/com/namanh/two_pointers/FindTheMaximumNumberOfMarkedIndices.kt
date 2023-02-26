package com.namanh.two_pointers

/**
 * https://leetcode.com/contest/weekly-contest-334/problems/find-the-maximum-number-of-marked-indices
 * You are given a 0-indexed integer array nums.
 * Initially, all of the indices are unmarked. You are allowed to make this operation any number of times:
 * - Pick two different unmarked indices i and j such that 2 * nums[i] <= nums[j], then mark i and j.
 * Return the maximum possible number of marked indices in nums using the above operation any number of times.
 *
 * S1: Sort array
 * S2: Use 2 pointers, right start at the end, left start at the middle
 *
 * Time: O(n * log(n))
 * Space: O(n)
 */
object FindTheMaximumNumberOfMarkedIndices {
    fun maxNumOfMarkedIndices(nums: IntArray): Int {
        val mark = BooleanArray(nums.size)
        nums.sort()
        var right = nums.size - 1
        var left = right / 2
        var result = 0
        while (true) {
            while (right >= 0 && mark[right]) {
                right--
            }
            while (left >= 0 && (mark[left] || 2 * nums[left] > nums[right])) {
                left--
            }
            if (left < 0) break
            mark[left] = true
            mark[right] = true
            result += 2
        }
        return result
    }
}