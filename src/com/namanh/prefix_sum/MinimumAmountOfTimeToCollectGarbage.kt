package com.namanh.prefix_sum

/**
 * https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage
 * You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith
 * house. garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass
 * garbage respectively. Picking up one unit of any type of garbage takes 1 minute.
 * You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house
 * i to house i + 1.
 * Return the minimum number of minutes needed to pick up all the garbage.
 *
 * S1: Transform travel array to prefix sum
 * S2: Iterate garbage array, count number character. Then add total move from travel array
 *
 * Time: O(n)
 * Space: O(1)
 */
object MinimumAmountOfTimeToCollectGarbage {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        for (i in 1 until travel.size) {
            travel[i] += travel[i-1]
        }
        var result = 0
        for (c in charArrayOf('M', 'P', 'G')) {
            var lastIdx = 0
            for ((i, gar) in garbage.withIndex()) {
                val numberC = gar.count { it == c }
                if (numberC > 0) {
                    lastIdx = i
                    result += numberC
                }
            }
            if (lastIdx > 0) result += travel[lastIdx-1]
        }
        return result
    }
}