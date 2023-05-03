package com.namanh.hash_table

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * - answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * - answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 *
 * Time: O(n)
 * Space: O(n)
 */
object FindTheDifferenceOfTwoArrays {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()
        val answer = List<MutableList<Int>>(2) { mutableListOf() }
        for (num in set1) {
            if (!set2.contains(num)) {
                answer[0].add(num)
            }
        }
        for (num in set2) {
            if (!set1.contains(num)) {
                answer[1].add(num)
            }
        }
        return answer
    }
}