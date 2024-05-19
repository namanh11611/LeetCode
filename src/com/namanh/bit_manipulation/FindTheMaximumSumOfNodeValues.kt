package com.namanh.bit_manipulation

import kotlin.math.abs

/**
 * https://leetcode.com/problems/find-the-maximum-sum-of-node-values
 * There exists an undirected tree with n nodes numbered 0 to n - 1. You are also given a positive integer k, and a
 * 0-indexed array of non-negative integers nums of length n, where nums[i] represents the value of the node numbered i.
 * Alice wants the sum of values of tree nodes to be maximum. Choose any edge [u, v] connecting the nodes u and v, and
 * update their values as follows:
 * - nums[u] = nums[u] XOR k
 * - nums[v] = nums[v] XOR k
 * Return the maximum possible sum of the values Alice can achieve by performing the operation any number of times.
 *
 * S1: For any two non-adjacent nodes U and V in the tree we can replace their values with the XOR values.
 * S2: If the number of netChange is positive is even, we can return current sum
 * S3: If the number of netChange is positive is odd, we have to reduce minChange
 *
 * Time: O(n)
 * Space: O(1)
 */
object FindTheMaximumSumOfNodeValues {
    fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
        var sum = 0L
        var minChange = Int.MAX_VALUE
        var count = 0
        for (num in nums) {
            val xorValue = num xor k
            sum += maxOf(num, xorValue)
            if (xorValue >= num) count++
            minChange = minOf(minChange, abs(xorValue - num))
        }
        return if (count and 1 == 0) sum else sum - minChange
    }
}
