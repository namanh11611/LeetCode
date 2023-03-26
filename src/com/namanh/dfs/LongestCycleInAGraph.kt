package com.namanh.dfs

/**
 * https://leetcode.com/problems/longest-cycle-in-a-graph
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.
 * The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from
 * node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.
 * Return the length of the longest cycle in the graph. If no cycle exists, return -1.
 */
object LongestCycleInAGraph {
    var answer = -1

    fun longestCycle(edges: IntArray): Int {
        val visit = BooleanArray(edges.size)
        for (i in edges.indices) {
            if (!visit[i]) {
                val dist = HashMap<Int, Int>()
                dist[i] = 1
                dfs(i, edges, dist, visit)
            }
        }
        return answer
    }

    private fun dfs(node: Int, edges: IntArray, dist: HashMap<Int, Int>, visit: BooleanArray) {
        visit[node] = true
        val neighbor = edges[node]
        if (neighbor != -1 && !visit[neighbor]) {
            dist[neighbor] = dist.getOrDefault(node, 0) + 1
            dfs(neighbor, edges, dist, visit)
        } else if (neighbor != -1 && dist.containsKey(neighbor)) {
            answer = maxOf(answer, dist.getOrDefault(node, 0) - dist.getOrDefault(neighbor, 0) + 1)
        }
    }
}