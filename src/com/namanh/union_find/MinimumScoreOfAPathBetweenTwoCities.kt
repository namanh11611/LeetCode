package com.namanh.union_find

/**
 * https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities
 * You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads
 * where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a
 * distance equal to distancei. The cities graph is not necessarily connected.
 * The score of a path between two cities is defined as the minimum distance of a road in this path.
 * Return the minimum possible score of a path between cities 1 and n.
 *
 * S1: Create an instance of UnionFind of size n + 1. In addition, create the result variable set to the maximum integer
 * S2: Iterate over all the graph's edges, or roads, and perform a merge of both nodes connected by an edge.
 * S3: Iterate over all the edges again. For each road, determine whether a component of node 1 is the same as one of
 * the ends of road. If both nodes belong to the same component, update result to the minimum of answer up to this point
 * and the weight of road. Otherwise, ignore edge road.
 *
 * Time: O(n + e)
 * Space: O(n)
 */
object MinimumScoreOfAPathBetweenTwoCities {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val unionFind = UnionFind(n + 1)
        var result = Int.MAX_VALUE
        for (road in roads) {
            unionFind.merge(road[0], road[1])
        }
        for (road in roads) {
            if (unionFind.find(1) == unionFind.find(road[0])) {
                result = minOf(result, road[2])
            }
        }
        return result
    }
}

class UnionFind(size: Int) {
    private val parent = IntArray(size)
    private val rank = IntArray(size)

    init {
        for (i in 0 until size) parent[i] = i
    }

    fun find(x: Int): Int {
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun merge(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) return
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY
        } else {
            parent[rootY] = rootX
            if (rank[rootX] == rank[rootY]) rank[rootX]++
        }
    }
}