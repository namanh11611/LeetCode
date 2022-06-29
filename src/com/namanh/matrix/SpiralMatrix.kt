package com.namanh.matrix

/**
 * https://leetcode.com/problems/spiral-matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * S1: Use top, bottom, left, right to limit for loop
 * S2: Increase top, left, decrease bottom, right after for loop
 *
 * Time: O(m * n)
 * Space: O(m * n)
 */
class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val m = matrix.size
        val n = matrix[0].size
        val result = mutableListOf<Int>()
        var index = 0
        var left = 0
        var right = n - 1
        var top = 0
        var bottom = m - 1
        while (result.size < m * n) {
            when (index % 4) {
                0 -> {
                    for (i in left..right) {
                        result.add(matrix[top][i])
                    }
                    top++
                }
                1 -> {
                    for (i in top..bottom) {
                        result.add(matrix[i][right])
                    }
                    right--
                }
                2 -> {
                    for (i in right downTo left) {
                        result.add(matrix[bottom][i])
                    }
                    bottom--
                }
                3 -> {
                    for (i in bottom downTo top) {
                        result.add(matrix[i][left])
                    }
                    left++
                }
            }
            index++
        }
        return result
    }
}