package com.namanh.matrix

/**
 * https://leetcode.com/problems/largest-local-values-in-a-matrix
 * You are given an n x n integer matrix grid. Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
 * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
 */
object LargestLocalValuesInAMatrix {
    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val dx = intArrayOf(1, 2, 0, 1, 2, 0, 1, 2)
        val dy = intArrayOf(0, 0, 1, 1, 1, 2, 2, 2)
        val n = grid.size
        val result = Array(n - 2) { IntArray(n - 2) }
        for (i in 0..n-3) {
            for (j in 0..n-3) {
                result[i][j] = grid[i][j]
                for (k in 0..7) {
                    result[i][j] = maxOf(result[i][j], grid[i + dx[k]][j + dy[k]])
                }
            }
        }
        return result
    }
}
