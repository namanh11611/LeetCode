package com.namanh.dfs

/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where
 * connections[i] = [ai, bi]. You can extract certain cables between two directly connected computers, and place them
 * between any pair of disconnected computers to make them directly connected.
 * Return the minimum number of times you need to do this in order to make all the computers connected.
 *
 * S1: Use DFS iterate over all computers
 * S2: Count number of connected components
 *
 * Time: O(n + e)
 * Space: O(n + e)
 */
object NumberOfOperationsToMakeNetworkConnected {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if (connections.size < n - 1) return -1
        val edge = HashMap<Int, MutableList<Int>>()
        for (c in connections) {
            edge.getOrPut(c[0]) { mutableListOf() }.add(c[1])
            edge.getOrPut(c[1]) { mutableListOf() }.add(c[0])
        }
        val visited = BooleanArray(n)
        var result = 0
        for (i in 0 until n) {
            if (!visited[i]) {
                result++
                dfs(i, edge, visited)
            }
        }
        return result - 1
    }

    private fun dfs(i: Int, edge: HashMap<Int, MutableList<Int>>, visited: BooleanArray) {
        visited[i] = true
        for (adj in edge.getOrDefault(i, mutableListOf())) {
            if (!visited[adj]) {
                dfs(adj, edge, visited)
            }
        }
    }
}