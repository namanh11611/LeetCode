package com.namanh.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination
 * Q: Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner
 * (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 *
 * S1: Use array have 3 dimension to store position and number obstacles
 * S2: Use BFS to visit all cells
 * S3: Return true when visit cell [m-1,n-1]
 */
public class ShortestPathInAGridWithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int c = 0; c < curSize; c++) {
                int[] curPos = queue.poll();
                if (curPos[0] == m - 1 && curPos[1] == n - 1) {
                    return level;
                }
                for (int i = 0; i < 4; i++) {
                    int row = curPos[0] + dr[i];
                    int col = curPos[1] + dc[i];
                    if (row >= 0 && row < m && col >= 0 && col < n) {
                        int remain = curPos[2];
                        if (grid[row][col] == 1) {
                            remain--;
                        }
                        if (remain >= 0 && !visited[row][col][remain]) {
                            queue.offer(new int[]{row, col, remain});
                            visited[row][col][remain] = true;
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
