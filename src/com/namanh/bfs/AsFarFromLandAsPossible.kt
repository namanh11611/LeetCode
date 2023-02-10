package com.namanh.bfs

import java.util.LinkedList

/**
 * https://leetcode.com/problems/as-far-from-land-as-possible
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell
 * such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in
 * the grid, return -1.
 *
 * S1: Use BFS to iterate matrix
 * S2: Each step, assign distance from land to water
 *
 * Time: O(n^2)
 * Space: O(n^2)
 */
object AsFarFromLandAsPossible {
    fun maxDistance(grid: Array<IntArray>): Int {
        val n = grid.size
        if (n == 1) return -1
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(1, 0, -1, 0)
        val queue = LinkedList<IntArray>()
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    queue.offer(intArrayOf(i, j))
                }
            }
        }
        if (queue.size == n * n) return -1

        var distance = 0
        while (queue.isNotEmpty()) {
            distance++
            for (i in 1..queue.size) {
                val cell = queue.poll()
                for (k in 0..3) {
                    val x = cell[0] + dx[k]
                    val y = cell[1] + dy[k]
                    if (x in 0 until n && y in 0 until n && grid[x][y] == 0) {
                        grid[x][y] = distance
                        queue.offer(intArrayOf(x, y))
                    }
                }
            }
        }
        return distance - 1
    }
}