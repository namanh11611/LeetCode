package com.namanh.binary_search

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days
 * A conveyor belt has packages that must be shipped from one port to another within days.
 * The ith package has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt. We may not
 * load more weight than the maximum weight capacity of the ship. Return the least weight capacity of the ship that will
 * result in all the packages on the conveyor belt being shipped within days.
 *
 * S1: Use binary search to find capacity in range from min capacity (max element) to max capacity (sum of all elements)
 *
 * Time: O(n * log(k)) with k is maxCap - minCap
 * Space: O(1)
 */
object CapacityToShipPackagesWithinDDays {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var minCap = 0
        var maxCap = 0
        for (w in weights) {
            if (w > minCap) minCap = w
            maxCap += w
        }
        while (minCap < maxCap) {
            val mid = minCap + (maxCap - minCap) / 2
            if (isValid(weights, days, mid)) {
                maxCap = mid
            } else {
                minCap = mid + 1
            }
        }
        return minCap
    }

    private fun isValid(weights: IntArray, days: Int, capacity: Int): Boolean {
        var totalDay = 1
        var curCap = 0
        for (w in weights) {
            curCap += w
            if (curCap > capacity) {
                totalDay++
                curCap = w
            }
        }
        return totalDay <= days
    }
}