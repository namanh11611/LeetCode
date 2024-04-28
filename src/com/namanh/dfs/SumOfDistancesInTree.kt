package com.namanh.dfs

/**
 * https://leetcode.com/problems/sum-of-distances-in-tree
 * There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges. Return an array answer of
 * length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
 *
 * S1: Initial an array count, count[i] counts all nodes in the subtree i.
 *     Initial an array of res, res[i] counts sum of distance in subtree i.
 * S2: Post order dfs traversal, update count and res:
 *     count[root] = sum(count[i]) + 1
 *     res[root] = sum(res[i]) + sum(count[i])
 * S3: Pre order dfs traversal, update res:
 *     When we move our root from parent to its child i, count[i] points get 1 closer to root, n - count[i] nodes get 1
 *     further to root.
 *     res[i] = res[root] - count[i] + N - count[i]
 *
 * Time: O(n)
 * Space: O(n)
 */
object SumOfDistancesInTree {
    fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
        val tree = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            tree[e[0]].add(e[1])
            tree[e[1]].add(e[0])
        }

        val count = IntArray(n)
        val res = IntArray(n)
        fun postOrderDfs(root: Int, pre: Int) {
            for (i in tree[root]) {
                if (i == pre) continue
                postOrderDfs(i, root)
                count[root] += count[i]
                res[root] += res[i] + count[i]
            }
            count[root]++
        }


        fun preOrderDfs(root: Int, pre: Int) {
            for (i in tree[root]) {
                if (i == pre) continue
                res[i] = res[root] - count[i] + count.size - count[i]
                preOrderDfs(i, root)
            }
        }

        postOrderDfs(0, -1)
        preOrderDfs(0, -1)
        return res
    }
}
