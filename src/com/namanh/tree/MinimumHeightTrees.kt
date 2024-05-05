package com.namanh.tree

/**
 * https://leetcode.com/problems/minimum-height-trees
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges. You can choose any node of the tree as
 * the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those
 * with minimum height (i.e. min(h))  are called minimum height trees (MHTs). Return a list of all MHTs' root labels.
 *
 * S1: There are at most 2 MHTs.
 * S2: Each step, find all leaves, trim them. Update new leaf.
 * S3: Loop until only have 1 or 2 node, return them.
 *
 * Time: O(n)
 * Space: O(n)
 */
class MinimumHeightTrees {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)
        val adj = Array(n) { HashSet<Int>() }
        for (edge in edges) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }
        var leaves = mutableListOf<Int>()
        for (i in 0 until n) {
            if (adj[i].size == 1) leaves.add(i)
        }
        var size = n
        while (size > 2) {
            size -= leaves.size
            val newLeaves = mutableListOf<Int>()
            for (i in leaves) {
                val j = adj[i].iterator().next()
                adj[j].remove(i)
                if (adj[j].size == 1) newLeaves.add(j)
            }
            leaves = newLeaves
        }
        return leaves
    }
}
