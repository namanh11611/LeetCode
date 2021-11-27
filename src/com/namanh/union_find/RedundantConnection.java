package com.namanh.union_find;

/**
 * https://leetcode.com/problems/redundant-connection
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers,
 * return the answer that occurs last in the input.
 *
 * S1: Find the first edge has 2 vertical in same root, because it will cause cycle
 * S2: Set parent for all vertical, note we set for index from 1 to n
 * S3: Iterate edges, if 2 vertical have same root, return it
 * S4: If not same root, use path compression to set new root
 *
 * Time: O(n)
 * Space: O(n)
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int rootA = findRoot(parent, edge[0]);
            int rootB = findRoot(parent, edge[1]);
            if (rootA != rootB) {
                parent[rootB] = rootA;
            } else {
                return edge;
            }
        }
        return new int[2];
    }

    private int findRoot(int[] parent, int x) {
        // Path compression
        if (parent[x] != x) {
            parent[x] = findRoot(parent, parent[x]);
        }
        return parent[x];
    }
}
