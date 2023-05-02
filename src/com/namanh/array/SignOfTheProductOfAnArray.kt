package com.namanh.array

/**
 * https://leetcode.com/problems/sign-of-the-product-of-an-array
 * There is a function signFunc(x) that returns:
 * - 1 if x is positive.
 * - -1 if x is negative.
 * - 0 if x is equal to 0.
 * You are given an integer array nums. Let product be the product of all values in the array nums.
 * Return signFunc(product).
 *
 * S1: Count the number of negative number
 * S2: Return 0 if we find an element equal 0
 * S3: Return 1 if the number of negative number is even
 *
 * Time: O(n)
 * Space: O(1)
 */
object SignOfTheProductOfAnArray {
    fun arraySign(nums: IntArray): Int {
        var countNegative = 0
        for (num in nums) {
            if (num == 0) return 0
            if (num < 0) countNegative++
        }
        return if (countNegative and 1 == 0) 1 else -1
    }
}