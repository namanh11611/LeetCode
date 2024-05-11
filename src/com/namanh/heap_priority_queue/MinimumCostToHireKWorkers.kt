package com.namanh.heap_priority_queue

import java.util.Collections
import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers
 * There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith
 * worker and wage[i] is the minimum wage expectation for the ith worker. We want to hire exactly k workers to form a
 * paid group. Every worker in the paid group must be paid at least their minimum wage expectation, and directly
 * proportional to their quality. Given the integer k, return the least amount of money needed to form a paid group
 * satisfying the above conditions.
 *
 * S1: Sort index ascending by wage/quality ratio
 * S2: Use heap to store k minimum qualities, multiple with current ratio to calculate total wage
 *
 * Time: O(n * log(n))
 * Space: O(n)
 */

object MinimumCostToHireKWorkers {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
        val n = quality.size
        val minRateIdx = PriorityQueue<Int> { a, b ->
            wage[a] * quality[b] - wage[b] * quality[a]
        }
        for (i in 0 until n) {
            minRateIdx.offer(i)
        }
        val minRate = IntArray(n)
        for (i in 0 until n) {
            minRate[i] = minRateIdx.poll()
        }

        var totalWage = Double.MAX_VALUE
        var qualitySum = 0
        val minQualitiesHeap = PriorityQueue<Int>(Collections.reverseOrder())
        for (i in 0 until n) {
            minQualitiesHeap.offer(quality[minRate[i]])
            qualitySum += quality[minRate[i]]

            if (minQualitiesHeap.size > k) {
                qualitySum -= minQualitiesHeap.poll()
            }

            if (minQualitiesHeap.size == k) {
                totalWage = minOf(totalWage, qualitySum.toDouble() / quality[minRate[i]] * wage[minRate[i]])
            }
        }
        return totalWage
    }
}
