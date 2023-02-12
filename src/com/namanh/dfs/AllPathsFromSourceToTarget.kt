package com.namanh.dfs

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node
 * n - 1 and return them in any order. The graph is given as follows: graph[i] is a list of all nodes you can visit from
 * node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 * S1: Use dfs to find all paths
 *
 * Time: O(2^n)
 * Space: O(2^n)
 */
object AllPathsFromSourceToTarget {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        dfs(graph, mutableListOf(0), result)
        return result
    }

    fun dfs(graph: Array<IntArray>, path: MutableList<Int>, result: MutableList<List<Int>>) {
        val prev = path.last()
        if (prev == graph.size - 1) {
            // We need to call path.toList() to clone this path
            result.add(path.toList())
            return
        }
        for (node in graph[prev]) {
            path.add(node)
            dfs(graph, path, result)
            path.remove(node)
        }
    }
}