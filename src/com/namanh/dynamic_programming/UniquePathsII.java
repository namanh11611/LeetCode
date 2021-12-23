package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/unique-paths-ii
 * A robot is located at the top-left corner of a m x n grid. The robot can only move either down or right at any point
 * in time. The robot is trying to reach the bottom-right corner of the grid. Now consider if some obstacles are added
 * to the grids. How many unique paths would there be?
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 * S1: Return 0 if start or end point has value equal 1
 * S2: Mark grid[0][0] = -1, we will use negative number to mark total path
 * S3: Fill first row and first column
 * S4: Use dp with formula grid[i][j] = grid[i-1][j] + grid[i][j-1]
 * S5: Fill other cell with negative number, if cell has value equal 1, ignore it
 * S6: Return grid[m-1][n-1]
 *
 * Time: O(m * n)
 * Space: O(1)
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        obstacleGrid[0][0] = -1;

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            obstacleGrid[i][0] = -1;
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            obstacleGrid[0][i] = -1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                int path1 = obstacleGrid[i - 1][j] == 1 ? 0 : obstacleGrid[i - 1][j];
                int path2 = obstacleGrid[i][j - 1] == 1 ? 0 : obstacleGrid[i][j - 1];
                obstacleGrid[i][j] = path1 + path2;
            }
        }

        return -obstacleGrid[m - 1][n - 1];
    }
}
