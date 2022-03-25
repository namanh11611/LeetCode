package com.namanh.dfs;

/**
 * https://leetcode.com/problems/unique-paths-iii
 * Given an m x n integer array grid where grid[i][j] could be: 1 - starting, 2 - ending, 0 - empty, -1 - obstacles.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over EVERY
 * non-obstacle square EXACTLY ONCE.
 *
 * S1: Brute-force by DFS, find all the way move from the starting square to the ending square
 * S2: If total visited square equal total empty square, increase result
 *
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class UniquePathsIII {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{-1, 0, 1, 0};
    int m, n;
    int totalVisited = 0;
    int totalEmpty = 1;
    int result = 0;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int startX = 0, startY = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    totalEmpty++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        dfs(grid, startX, startY);
        return result;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] < 0) return;

        if (grid[x][y] == 2) {
            if (totalEmpty == totalVisited) {
                result++;
            }
            return;
        }

        grid[x][y] = -2;
        totalVisited++;
        for (int i = 0; i < 4; i++) {
            dfs(grid, x + dx[i], y + dy[i]);
        }
        grid[x][y] = 0;
        totalVisited--;
    }
}
