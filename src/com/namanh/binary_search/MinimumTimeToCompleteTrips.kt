package com.namanh.binary_search

/**
 * https://leetcode.com/problems/minimum-time-to-complete-trips
 * You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip. Each bus can
 * make multiple trips successively. Also, each bus operates independently. You are also given an integer totalTrips,
 * which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to
 * complete at least totalTrips trips.
 *
 * S1: Use binary search to find time. Left is minimum value in array, right is minimum value * totalTrips
 *
 * Time: O(n * log(m*k)) with m is minimum value, k is totalTrips
 * Space: O(1)
 */
object MinimumTimeToCompleteTrips {
    fun minimumTime(time: IntArray, totalTrips: Int): Long {
        var minTime = time[0]
        time.forEach {
            minTime = minOf(minTime, it)
        }
        var left = minTime.toLong()
        var right = minTime.toLong() * totalTrips
        while (left < right) {
            val mid = left + (right - left) / 2
            if (isValid(time, mid, totalTrips)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun isValid(time: IntArray, t: Long, totalTrips: Int): Boolean {
        var numberTrip = 0L
        time.forEach {
            numberTrip += t / it
            if (numberTrip >= totalTrips) return true
        }
        return numberTrip >= totalTrips
    }
}