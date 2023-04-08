package com.namanh.graph

/**
 * https://leetcode.com/problems/clone-graph
 * Given a reference of a node in a connected undirected graph. Return a deep copy (clone) of the graph.
 */
object CloneGraph {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        val root = Node(node.`val`)
        val visited = Array<Node?>(101) { null }
        dfs(node, root, visited)
        return root
    }

    fun dfs(oldNode: Node?, newNode: Node?, visited: Array<Node?>) {
        visited[newNode?.`val` ?: 0] = newNode
        for (nei in oldNode?.neighbors ?: emptyList<Node>()) {
            if (visited[nei?.`val` ?: 0] == null) {
                val new = Node(nei?.`val` ?: 0)
                newNode?.neighbors?.add(new)
                dfs(nei, new, visited)
            } else {
                newNode?.neighbors?.add(visited[nei?.`val` ?: 0])
            }
        }
    }
}

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
