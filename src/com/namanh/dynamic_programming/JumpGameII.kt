package com.namanh.dynamic_programming

/**
 * https://leetcode.com/problems/jump-game-ii
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i.
 * Return the minimum number of jumps to reach nums[n - 1].
 */
object JumpGameII {
    /**
     * Dynamic programing
     *
     * S1: Number steps array: 0 1 1 2 2        2          3 3     3
     *                                   lastIdxOfCurStep     maxReach
     * S2: Maintain max index we can reach
     * S3: Increase number step when iterate to lastIdxOfCurStep
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun jump(nums: IntArray): Int {
        var step = 0
        var lastIdxOfCurStep = 0
        var maxReach = 0
        for (i in 0 until nums.size - 1) {
            maxReach = maxReach.coerceAtLeast(i + nums[i])
            if (i == lastIdxOfCurStep) {
                step++
                lastIdxOfCurStep = maxReach
            }
        }
        return step
    }

    /**
     * Dynamic programing
     *
     * S1: Maintain max index we can reach
     * S2: If we found a nums that gets us further, set minimum step for [maxReach, i + nums[i]]
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun jump1(nums: IntArray): Int {
        val size = nums.size
        val steps = IntArray(size) { it }
        var maxReach = 0
        for (i in nums.indices) {
            val maxSize = Math.min(size - 1, i + nums[i])
            if (maxSize > maxReach) {
                for (j in maxReach + 1..maxSize) {
                    steps[j] = steps[i] + 1
                }
                maxReach = maxSize
                if (maxReach == size - 1) break
            }
        }
        return steps[size - 1]
    }

    /**
     * Brute-force
     *
     * Time: O(n^2)
     * Space: O(n)
     */
    fun jump2(nums: IntArray): Int {
        val size = nums.size
        val steps = IntArray(size) { it }
        for (i in 1 until size) {
            for (j in 0 until i) {
                if (i - j <= nums[j]) {
                    steps[i] = steps[i].coerceAtMost(steps[j] + 1)
                }
            }
        }
        return steps[size - 1]
    }
}