package com.namanh.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix
 * Q: Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no
 * clear path, return -1. A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the
 * bottom-right cell (i.e., (n - 1, n - 1)), all the visited cells of the path are 0.
 *
 * S1: Return -1 if grid[0][0] != 0 or grid[n-1][n-1] != 0
 * S2: Use Queue, add cell [0,0], define value is 1
 * S3: Check 8 directions, if cell valid and value == 0, add to queue, define value is current cell value + 1
 * S4: Return when found cell [n-1][n-1]
 * S5: If value of cell [n-1][n-1] still is 0, return -1
 */
public class ShortestPathInBinaryMatrix {
    int[] dr = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    int[] dc = new int[]{1, 1, 0, -1, -1, -1, 0, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int step = grid[cell[0]][cell[1]];

            for (int i = 0; i < 8; i++) {
                int row = cell[0] + dr[i];
                int col = cell[1] + dc[i];
                if (row == n - 1 && col == n - 1) {
                    return step + 1;
                }
                if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                    grid[row][col] = step + 1;
                }
            }
        }
        return grid[n-1][n-1] != 0 ? grid[n-1][n-1] : -1;
    }
}
