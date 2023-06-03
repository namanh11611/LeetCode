package com.namanh.hash_table

/**
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions
 * You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
 * - The 2D array should contain only the elements of the array nums.
 * - Each row in the 2D array contains distinct integers.
 * - The number of rows in the 2D array should be minimal.
 * Return the resulting array. If there are multiple answers, return any of them.
 *
 * S1: Iterate each number in array
 * S2: Use Set to store the elements of row
 * S3: Check if each row contain the number. If not, add it to this row
 * S4: Convert Set to List
 *
 * Time: O(n)
 * Space: O(n)
 */
object ConvertAnArrayIntoA2DArrayWithConditions {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val array = mutableListOf<MutableSet<Int>>()
        for_loop@ for (num in nums) {
            for (set in array) {
                if (!set.contains(num)) {
                    set.add(num)
                    continue@for_loop
                }
            }
            array.add(mutableSetOf(num))
        }
        return array.map { it.toList() }
    }
}