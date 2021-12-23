package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/unique-paths
 * A robot is located at the top-left corner of a m x n grid. The robot can only move either down or right at any point
 * in time. The robot is trying to reach the bottom-right corner of the grid. How many possible unique paths are there?
 *
 * S1: Use an array has size m+1 * n+1
 * S2: Dp with formula path[i][j] = path[i-1][j] + path[i][j-1]
 * S3: Mark path[1][1] = 1 and ignore it when iterate path array
 * S4: Return path[m][n]
 *
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m + 1][n + 1];
        path[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                path[i][j] = path[i][j - 1] + path[i - 1][j];
            }
        }
        return path[m][n];
    }
}
