package com.namanh.dfs

/**
 * https://leetcode.com/problems/path-with-maximum-gold
 * In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell
 * Return the maximum amount of gold you can collect under the conditions:
 * - Every time you are located in a cell you will collect all the gold in that cell.
 * - From your position, you can walk one step to the left, right, up, or down.
 * - Never visit a cell with 0 gold.
 * - You can start and stop collecting gold from any position in the grid that has some gold.
 *
 * S1: Use DFS
 *
 * Time: O(m^2 * n^2)
 * Space: O(m * n)
 */
object PathWithMaximumGold {
    fun getMaximumGold(grid: Array<IntArray>): Int {
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(1, 0, -1, 0)
        val m = grid.size
        val n = grid[0].size

        fun dfs(i: Int, j: Int): Int {
            if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 0) return 0

            val originalVal = grid[i][j]
            grid[i][j] = 0

            var gold = 0
            for (k in 0..3) {
                gold = maxOf(gold, dfs(i + dx[k], j + dy[k]))
            }

            grid[i][j] = originalVal
            return gold + originalVal
        }

        var maxGold = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                maxGold = maxOf(maxGold, dfs(i, j))
            }
        }
        return maxGold
    }
}
