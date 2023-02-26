package com.namanh.array

/**
 * https://leetcode.com/problems/watering-plants
 * Given a 0-indexed integer array plants of n integers, where plants[i] is the amount of water the ith plant needs,
 * and an integer capacity representing the watering can capacity. There is a river at x = -1 that you can refill your
 * watering can at. Return the number of steps needed to water all the plants.
 *
 * S1: Each step, if plants[i] make we cannot water, add number step and reset sum of water
 *
 * Time: O(n)
 * Space: O(1)
 */
object WateringPlants {
    fun wateringPlants(plants: IntArray, capacity: Int): Int {
        var result = plants.size
        var sum = 0
        for (i in plants.indices) {
            if (sum + plants[i] > capacity) {
                result += 2 * i
                sum = 0
            }
            sum += plants[i]
        }
        return result
    }
}