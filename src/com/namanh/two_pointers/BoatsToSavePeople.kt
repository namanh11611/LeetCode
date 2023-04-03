package com.namanh.two_pointers

/**
 * https://leetcode.com/problems/boats-to-save-people
 * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where
 * each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the
 * sum of the weight of those people is at most limit. Return the minimum number of boats to carry every given person.
 *
 * S1: Use two pointer. Each step, check if sum less than or equal limit, increase left pointer
 * S2: Increase right pointer and counter
 *
 * Time: O(n * log(n))
 * Space: O(1)
 */
object BoatsToSavePeople {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        var result = 0
        var left = 0
        var right = people.size - 1
        people.sort()
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++
            }
            right--
            result++
        }
        return result
    }
}