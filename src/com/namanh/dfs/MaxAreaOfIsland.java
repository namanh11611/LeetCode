package com.namanh.dfs;

/**
 * Link: https://leetcode.com/problems/max-area-of-island
 * Question: You are given an m x n binary matrix grid. The area of an island is the number of cells with a value 1
 * on the island. Return the maximum area of an island in grid.
 * S1: Use DFS to visit grid, change cell's value to 2 if visited
 * S2: Calculate area after every DFS, find maximum
 */
public class MaxAreaOfIsland {
    int m, n, currentArea;
    int[] drow = new int[]{0, 1, 0, -1};
    int[] dcol = new int[]{1, 0, -1, 0};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    currentArea = 0;
                    dfs(grid, i, j);
                    if (currentArea > maxArea) maxArea = currentArea;
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int row, int col) {
        grid[row][col] = 2;
        currentArea++;
        for (int k = 0; k < 4; k++) {
            int nrow = row + drow[k];
            int ncol = col + dcol[k];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                dfs(grid, nrow, ncol);
            }
        }
    }
}
