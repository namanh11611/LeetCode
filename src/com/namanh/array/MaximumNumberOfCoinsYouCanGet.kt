package com.namanh.array

/**
 * https://leetcode.com/problems/maximum-number-of-coins-you-can-get
 * There are 3n piles of coins of varying size, you and your friends will take piles of coins as follows:
 * - In each step, you will choose any 3 piles of coins (not necessarily consecutive).
 * - Of your choice, Alice will pick the pile with the maximum number of coins.
 * - You will pick the next pile with the maximum number of coins.
 * - Your friend Bob will pick the last pile.
 * Return the maximum number of coins that you can have.
 *
 * S1: Sort array descending
 * S2: We will take the second-biggest coin: Alice Me Alice Me ... Bob Bob ...
 *
 * Time: O(n)
 * Space: O(1)
 */
object MaximumNumberOfCoinsYouCanGet {
    fun maxCoins(piles: IntArray): Int {
        val n = (piles.size + 1) / 3
        var sum = 0
        piles.sortDescending()
        for (i in 1..n) {
            sum += piles[2 * i - 1]
        }
        return sum
    }
}