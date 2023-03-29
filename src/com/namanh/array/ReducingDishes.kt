package com.namanh.array

/**
 * https://leetcode.com/problems/reducing-dishes
 * A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.
 * Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied
 * by its satisfaction level i.e. time[i] * satisfaction[i].
 * Return the maximum sum of like-time coefficient that the chef can obtain after dishes preparation.
 *
 * S1: Sort the array
 * S2: Iterate over array, each step, compare a*1 + b*2 + c*3 with b*1 + c*2
 *
 * Time: O(n * log(n))
 * Space: O(1)
 */
object ReducingDishes {

    /**
     * Optimize solution, from last to first
     */
    fun maxSatisfaction(satisfaction: IntArray): Int {
        satisfaction.sort()
        var result = 0
        var suffixSum = 0
        for (i in satisfaction.size - 1 downTo 0) {
            suffixSum += satisfaction[i]
            result = maxOf(result, result + suffixSum)
        }
        return result
    }

    /**
     * Naive solution, from first to last
     */
    fun maxSatisfaction1(satisfaction: IntArray): Int {
        satisfaction.sort()
        var result = 0
        var suffixSum = 0
        for (i in satisfaction.indices) {
            result += satisfaction[i] * (i + 1)
            suffixSum += satisfaction[i]
        }
        for (s in satisfaction) {
            result = maxOf(result, result - suffixSum)
            suffixSum -= s
        }
        return result
    }
}