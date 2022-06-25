package com.namanh.array

/**
 * https://leetcode.com/problems/maximum-product-subarray
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and
 * return the product.
 *
 * S1: Store maximum negative number, product from start or 0-value
 * S2: Iterate nums, reset value when meet 0-value
 * S3: If product > 0, compare result with product and assign
 * S4: If product < 0, compare result with product/maxNeg, assign maxNeg if needed
 *
 * Time: O(n)
 * Space: O(1)
 */
class MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        var maxNeg = Int.MIN_VALUE
        var product = 1
        var result = nums[0]
        for (num in nums) {
            if (num == 0) {
                maxNeg = Int.MIN_VALUE
                product = 1
                if (result < 0) {
                    result = 0
                }
                continue
            }
            product *= num

            if (product > 0) {
                if (product > result) {
                    result = product
                }
            } else {
                if (maxNeg > Int.MIN_VALUE && product / maxNeg > result) {
                    result = product / maxNeg
                }
                if (product > maxNeg) {
                    maxNeg = product
                }
            }
        }
        return result
    }
}