package com.namanh.dfs

/**
 * https://leetcode.com/problems/detonate-the-maximum-bombs
 *
 * S1: Build graph with adjacent bomb
 * S2: DFS from each bomb to find the maximum
 *
 * Time: O(n^3)
 * Space: O(n^2)
 */
object DetonateTheMaximumBombs {
    fun maximumDetonation(bombs: Array<IntArray>): Int {
        val graph = Array(bombs.size) { emptyList<Int>() }
        for (i in bombs.indices) {
            val adjacent = mutableListOf<Int>()
            for (j in bombs.indices) {
                if (i == j) continue
                val dx = (bombs[i][0] - bombs[j][0]).toLong()
                val dy = (bombs[i][1] - bombs[j][1]).toLong()
                val r = bombs[i][2].toLong()
                if (dx * dx + dy * dy <= r * r) {
                    adjacent.add(j)
                }
            }
            graph[i] = adjacent
        }

        var count = 0
        fun dfs(visited: BooleanArray, index: Int) {
            if (visited[index]) return
            visited[index] = true
            count++
            graph[index].forEach {
                dfs(visited, it)
            }
        }

        var result = 0
        for (i in bombs.indices) {
            count = 0
            dfs(BooleanArray(bombs.size) { false }, i)
            result = maxOf(result, count)
        }
        return result
    }
}