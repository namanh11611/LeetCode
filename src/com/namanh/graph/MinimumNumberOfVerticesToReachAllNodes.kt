package com.namanh.graph

/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [i, j]
 * represents a directed edge from node i to node j.
 * Find the smallest set of vertices from which all nodes in the graph are reachable.
 *
 * S1: Mark all nodes have income path
 * S2: Return all nodes don't have income path
 *
 * Time: O(n)
 * Space: O(n)
 */
object MinimumNumberOfVerticesToReachAllNodes {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val visited = BooleanArray(n)
        for (e in edges) {
            visited[e[1]] = true
        }
        val result = mutableListOf<Int>()
        for (i in 0 until n) {
            if (!visited[i]) {
                result.add(i)
            }
        }
        return result
    }
}