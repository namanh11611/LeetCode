package com.namanh.array

/**
 * https://leetcode.com/problems/shuffle-the-array
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 *
 * Time: O(n)
 * Space: O(1), because we are not using any additional space other than the output array.
 */
object ShuffleTheArray {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val result = IntArray(2 * n)
        for (i in 0 until n) {
            result[2 * i] = nums[i]
            result[2 * i + 1] = nums[i + n]
        }
        return result
    }
}