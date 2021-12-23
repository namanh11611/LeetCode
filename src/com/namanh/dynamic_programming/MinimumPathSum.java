package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/minimum-path-sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the
 * sum of all numbers along its path. Note: You can only move either down or right at any point in time.
 *
 * S1: Use dp with formula grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j])
 * S2: Note special case first row, first column and first cell
 * S3: Return grid[m-1][n-1]
 *
 * Time: O(m * n)
 * Space: O(1)
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                } else if (i == 0 && j > 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (i > 0) {
                    grid[i][j] += grid[i - 1][j];
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
