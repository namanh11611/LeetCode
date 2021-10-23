package com.namanh.dfs;

/**
 * Link: https://leetcode.com/problems/number-of-provinces
 * Question: A province is a group of directly or indirectly connected cities and no other cities outside the group.
 * Return the total number of provinces.
 * S1: Use DFS to visit all node by row
 * S2: Number provinces is number of connected components
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int numberProvinces = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                numberProvinces++;
                dfs(isConnected, i, n, visited);
            }
        }
        return numberProvinces;
    }

    private void dfs(int[][] isConnected, int node, int n, int[] visited) {
        visited[node] = 1;
        int[] adjNode = isConnected[node];
        for (int i = 0; i < n; i++) {
            if (i != node && adjNode[i] == 1 && visited[i] == 0) {
                dfs(isConnected, i, n, visited);
            }
        }
    }
}
