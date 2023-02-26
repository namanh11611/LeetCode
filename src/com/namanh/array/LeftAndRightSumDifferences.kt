package com.namanh.array

import kotlin.math.abs

/**
 * https://leetcode.com/contest/weekly-contest-334/problems/left-and-right-sum-differences
 * Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:
 * - answer[i] = |leftSum[i] - rightSum[i]|.
 * Where:
 * - leftSum[i] is the sum of elements to the left of the index i in the array nums.
 * - rightSum[i] is the sum of elements to the right of the index i in the array nums.
 * Return the array answer.
 */
object LeftAndRightSumDifferences {
    fun leftRigthDifference(nums: IntArray): IntArray {
        var leftSum = 0
        var rightSum = nums.sum() - nums[0]
        val result = IntArray(nums.size)
        result[0] = rightSum
        for (i in 1 until nums.size) {
            leftSum += nums[i-1]
            rightSum -= nums[i]
            result[i] = abs(leftSum - rightSum)
        }
        return result
    }
}