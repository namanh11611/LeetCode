package com.namanh.dfs;

/**
 * Link: https://leetcode.com/problems/number-of-islands
 * Question: Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number
 * of islands.
 * S1: Use DFS to visit grid, change value to '2' if visited
 * S2: Count number of connected components
 */
public class NumberOfIslands {
    int m, n;
    int[] drow = new int[]{0, 1, 0, -1};
    int[] dcol = new int[]{1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int numberIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numberIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numberIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '2';
        for (int k = 0; k < 4; k++) {
            int nrow = row + drow[k];
            int ncol = col + dcol[k];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == '1') {
                dfs(grid, nrow, ncol);
            }
        }
    }
}
