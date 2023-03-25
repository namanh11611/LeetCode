package com.namanh.bfs

import java.util.LinkedList
import kotlin.collections.HashMap

/**
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph
 * You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D
 * integer array edges where edges[i] = [a, b] denotes that there exists an undirected edge connecting nodes a and b.
 * Return the number of pairs of different nodes that are unreachable from each other.
 *
 * S1: Use BFS to traversal the independent component
 * S2: For each component, we will add it multiple total element of previous components to result
 *
 * Time: O(n + e)
 * Space: O(n + e)
 */
object CountUnreachablePairsOfNodesInAnUndirectedGraph {
    fun countPairs(n: Int, edges: Array<IntArray>): Long {
        val edgeMap = HashMap<Int, MutableList<Int>>()
        for (edge in edges) {
            edgeMap.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
            edgeMap.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
        }
        val visited = BooleanArray(n)
        var result = 0L
        var prevComponents = 0L
        var curComponent: Int
        for (i in 0 until n) {
            if (!visited[i]) {
                curComponent = bfs(i, visited, edgeMap)
                result += prevComponents * curComponent
                prevComponents += curComponent
            }
        }
        return result
    }

    private fun bfs(node: Int, visited: BooleanArray, edgeMap: HashMap<Int, MutableList<Int>>): Int {
        var size = 0
        val queue = LinkedList<Int>()
        queue.offer(node)
        visited[node] = true
        while (queue.isNotEmpty()) {
            val i = queue.poll()
            size++
            for (adj in edgeMap.getOrDefault(i, mutableListOf())) {
                if (!visited[adj]) {
                    queue.offer(adj)
                    visited[adj] = true
                }
            }
        }
        return size
    }
}