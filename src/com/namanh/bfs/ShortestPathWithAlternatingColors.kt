package com.namanh.bfs

import java.util.ArrayDeque

/**
 * https://leetcode.com/problems/shortest-path-with-alternating-colors
 * You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each
 * edge is red or blue in this graph, and there could be self-edges and parallel edges.
 * You are given two arrays redEdges and blueEdges where:
 * - redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
 * - blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
 * Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x
 * such that the edge colors alternate along the path, or -1 if such a path does not exist.
 *
 * S1: Create adjacent map
 * S2: Use BFS to traversal tree
 * S3: Remember that we need to distinguish node with red or blue
 *
 * Time: O(n + m) with m is number edges
 * Space: O(n + m)
 */
object ShortestPathWithAlternatingColors {
    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        val result = IntArray(n) { -1 }
        val redAdj = HashMap<Int, MutableList<Int>>()
        redEdges.forEach { edge ->
            redAdj.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
        }
        val blueAdj = HashMap<Int, MutableList<Int>>()
        blueEdges.forEach { edge ->
            blueAdj.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
        }

        val redNode = IntArray(n) { if (it == 0) 0 else -1 }
        val blueNode = IntArray(n) { if (it == 0) 0 else -1 }
        val queue = ArrayDeque<Pair<Int, Boolean>>() // The first element is index, second is color
        queue.offer(0 to true) // true is red
        queue.offer(0 to false) // false is blue
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 1..size) {
                val element = queue.poll()
                val node = element.first
                if (element.second) {
                    blueAdj[node]?.forEach {
                        if (blueNode[it] == -1) {
                            queue.add(it to false)
                            blueNode[it] = redNode[node] + 1
                        }
                    }
                } else {
                    redAdj[node]?.forEach {
                        if (redNode[it] == -1) {
                            queue.add(it to true)
                            redNode[it] = blueNode[node] + 1
                        }
                    }
                }
            }
        }

        for (i in 0 until n) {
            if (redNode[i] == -1) {
                result[i] = blueNode[i]
            } else if (blueNode[i] == -1) {
                result[i] = redNode[i]
            } else {
                result[i] = minOf(redNode[i], blueNode[i])
            }
        }
        return result
    }
}