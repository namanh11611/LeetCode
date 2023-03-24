package com.namanh.bfs

import java.util.LinkedList
import kotlin.collections.HashMap

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two
 * different cities (this network form a tree). Roads are represented by connections where connections[i] = [ai, bi]
 * represents a road from city ai to city bi. Your task consists of reorienting some roads such that each city can visit
 * the city 0. Return the minimum number of edges changed.
 *
 * S1: Create edge map, add a param to denote the direction of edge
 * S2: Use BFS to traversal, count the number of edge need to flip
 *
 * Time: O(n)
 * Space: O(n)
 */
object ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val edge = HashMap<Int, MutableList<Pair<Int, Int>>>()
        for (c in connections) {
            edge.getOrPut(c[0]) { mutableListOf() }.add(c[1] to 1)
            edge.getOrPut(c[1]) { mutableListOf() }.add(c[0] to 0)
        }

        val queue = LinkedList<Int>()
        val visited = BooleanArray(n)
        var result = 0
        queue.offer(0)
        visited[0] = true
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            for (adj in edge.getOrDefault(node, mutableListOf())) {
                if (!visited[adj.first]) {
                    result += adj.second
                    visited[adj.first] = true
                    queue.offer(adj.first)
                }
            }
        }
        return result
    }
}