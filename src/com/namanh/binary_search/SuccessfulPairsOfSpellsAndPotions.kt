package com.namanh.binary_search

/**
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions
 * You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i]
 * represents the strength of the ith spell and potions[j] represents the strength of the jth potion. You are also given
 * an integer success. A spell and potion pair is considered successful if the product of their strengths is at least
 * success. Return an integer array pairs of length n where pairs[i] is the number of potions that will form a
 * successful pair with the ith spell.
 *
 * S1: Sort potions
 * S2: Use binary search to find number of the value in potions multiple spells greater than success
 *
 * Time: O(n * log(n))
 * Space: O(n)
 */
object SuccessfulPairsOfSpellsAndPotions {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        potions.sort()
        val result = IntArray(spells.size)
        fun binarySearch(value: Long): Int {
            var left = 0
            var right = potions.size - 1
            if (value > potions[right]) return 0
            while (left < right) {
                val mid = left + (right - left) / 2
                if (potions[mid] >= value) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }
            return potions.size - left
        }
        for (i in spells.indices) {
            result[i] = binarySearch((success - 1) / spells[i] + 1)
        }
        return result
    }
}