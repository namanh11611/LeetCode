package com.namanh.matrix

/**
 * https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column
 * You are given a 0-indexed m x n binary matrix grid.
 * A 0-indexed m x n difference matrix diff is created with the following procedure:
 * - Let the number of ones in the ith row be onesRow.
 * - Let the number of ones in the jth column be onesColj.
 * - Let the number of zeros in the ith row be zerosRowi.
 * - Let the number of zeros in the jth column be zerosColj.
 * - diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
 * Return the difference matrix diff.
 */
object DifferenceBetweenOnesAndZerosInRowAndColumn {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val oneRow = IntArray(m)
        val zeroRow = IntArray(m)
        val oneCol = IntArray(n)
        val zeroCol = IntArray(n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    oneRow[i]++
                    oneCol[j]++
                } else {
                    zeroRow[i]++
                    zeroCol[j]++
                }
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                grid[i][j] = oneRow[i] + oneCol[j] - zeroRow[i] - zeroCol[j]
            }
        }
        return grid
    }
}