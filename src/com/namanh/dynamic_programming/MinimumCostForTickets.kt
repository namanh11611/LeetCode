package com.namanh.dynamic_programming

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets
 * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as
 * an integer array days. Each day is an integer from 1 to 365. Train tickets are sold in three different ways:
 * - a 1-day pass is sold for costs[0] dollars,
 * - a 7-day pass is sold for costs[1] dollars, and
 * - a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 * S1: Use dynamic programing with formula minCost[i] = minOf(minCost[i-1] + cost[0], minCost[i-7] + cost[1], minCost[i-30] + cost[2])
 * S2: Remember set minCost[i-k] = 0 for small index
 *
 * Time: O(n)
 * Space: O(n)
 */
object MinimumCostForTickets {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val minCost = IntArray(366)
        var id = 0
        var prev = 0
        for (i in 1 until minCost.size) {
            if (id < days.size && i == days[id]) {
                id++
                minCost[i] = minOf(costs[0] * id, minCost[i - 1] + costs[0])

                val prev7 = if (i >= 7) minCost[i - 7] else 0
                minCost[i] = minOf(minCost[i], prev7 + costs[1])

                val prev30 = if (i >= 30) minCost[i - 30] else 0
                minCost[i] = minOf(minCost[i], prev30 + costs[2])

                prev = minCost[i]
            } else {
                minCost[i] = prev
            }
        }
        return minCost[365]
    }
}