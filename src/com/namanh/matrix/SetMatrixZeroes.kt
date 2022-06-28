package com.namanh.matrix

/**
 * https://leetcode.com/problems/set-matrix-zeroes
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * S1: Use set to store zero row and column
 * S2: Iterate matrix and set zero
 *
 * Time: O(m * n)
 * Space: O(m + n)
 */
class SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val m = matrix.size
        val n = matrix[0].size
        val zeroRow = mutableSetOf<Int>()
        val zeroCol = mutableSetOf<Int>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    zeroRow.add(i)
                    zeroCol.add(j)
                }
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i in zeroRow || j in zeroCol) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}