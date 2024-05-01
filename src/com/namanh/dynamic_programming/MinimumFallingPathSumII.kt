package com.namanh.dynamic_programming

/**
 * https://leetcode.com/problems/minimum-falling-path-sum-ii
 * Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts (no two elements
 * chosen in adjacent rows are in the same column).
 *
 * S1: Use dynamic programming, store first and second minimum value of previous row (with first index)
 * S2: Update current dp row, update first and second minimum value
 *
 * Time: O(n^2)
 * Space: O(n^2)
 */
object MinimumFallingPathSumII {
    fun minFallingPathSum(grid: Array<IntArray>): Int {
        val n = grid.size
        if (n == 1) return grid[0][0]
        val dp = Array(n + 1) { IntArray(n) }
        var prevFirstMin = 0
        var prevFirstMinIdx = -1
        var prevSecondMin = 0
        for (i in 0 until n) {
            var firstMin = Int.MAX_VALUE
            var firstMinIdx = -1
            var secondMin = Int.MAX_VALUE
            for (j in 0 until n) {
                dp[i + 1][j] = grid[i][j] + (if (j != prevFirstMinIdx) prevFirstMin else prevSecondMin)
                if (dp[i + 1][j] <= firstMin) {
                    secondMin = firstMin
                    firstMin = dp[i + 1][j]
                    firstMinIdx = j
                } else if (dp[i + 1][j] < secondMin) {
                    secondMin = dp[i + 1][j]
                }
            }
            prevFirstMin = firstMin
            prevFirstMinIdx = firstMinIdx
            prevSecondMin = secondMin
        }
        return prevFirstMin
    }
}
