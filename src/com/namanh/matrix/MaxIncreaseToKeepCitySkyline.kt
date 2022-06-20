package com.namanh.matrix

/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline
 * There is a city composed of n x n blocks, where each block contains a single building shaped like a vertical square
 * prism. We are allowed to increase the height of any number of buildings by any amount. Return the maximum total sum
 * that the height of the buildings can be increased by without changing the city's skyline from any cardinal direction.
 *
 * S1: Find max value of each row and column
 * S2: Increase each cell to minimum of max row and max column
 *
 * Time: O(n^2)
 * Space: O(n)
 */
class MaxIncreaseToKeepCitySkyline {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val n = grid.size
        val maxRow = IntArray(n)
        val maxCol = IntArray(n)
        var total = 0
        for ((i, row) in grid.withIndex()) {
            for ((j, cel) in row.withIndex()) {
                maxRow[i] = Integer.max(cel, maxRow[i])
                maxCol[j] = Integer.max(cel, maxCol[j])
            }
        }

        for ((i, row) in grid.withIndex()) {
            for ((j, cel) in row.withIndex()) {
                total += Integer.min(maxRow[i], maxCol[j]) - cel
            }
        }
        return total
    }
}