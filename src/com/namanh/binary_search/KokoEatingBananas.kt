package com.namanh.binary_search

/**
 * https://leetcode.com/problems/koko-eating-bananas
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and
 * will come back in h hours. Her bananas-per-hour eating speed is k. Each hour, she chooses some pile of bananas and
 * eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any
 * more bananas during this hour. Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * S1: Use binary search to check from 1 to maximum element
 *
 * Time: O(n * log(m))
 * Space: O(1)
 */
object KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = 0
        for (pile in piles) {
            right = maxOf(right, pile)
        }
        while (left < right) {
            val mid = left + (right - left) / 2
            if (canEat(piles, h, mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun canEat(piles: IntArray, h: Int, k: Int): Boolean {
        var time = 0
        for (pile in piles) {
            // Use pile - 1 to get exactly time when pile % k == 0
            time += (pile - 1) / k + 1
            if (time > h) return false
        }
        return time <= h
    }
}
