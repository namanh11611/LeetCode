package com.namanh.dynamic_programming

/**
 * https://leetcode.com/problems/freedom-trail
 *
 * S1: Dynamic programming bottom-up
 *
 * Time: O(n^2 * k)
 * Space: O(n * k)
 */
object FreedomTrail  {
    fun findRotateSteps(ring: String, key: String): Int {
        val n = ring.length
        val k = key.length
        val charMap = Array(26) { mutableListOf<Int>() }
        for (i in ring.indices) {
            charMap[ring[i] - 'a'].add(i)
        }

        val dp = Array(k) { IntArray(n) { Int.MAX_VALUE } }
        for (i in charMap[key[0] - 'a']) {
            dp[0][i] = minOf(i, n - i) + 1
        }

        for (p in 1 until k) {
            for (i in charMap[key[p] - 'a']) {
                for (j in charMap[key[p - 1] - 'a']) {
                    val distance = if (i > j) {
                        minOf(i - j, n - i + j)
                    } else {
                        minOf(j - i, n - j + i)
                    }
                    dp[p][i] = minOf(dp[p][i], dp[p - 1][j] + distance)
                }
                dp[p][i]++
            }
        }

        return dp[k - 1].minOrNull() ?: 0
    }
}
