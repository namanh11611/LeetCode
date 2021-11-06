package com.namanh.binary_search;

import java.util.Stack;

/**
 * https://leetcode.com/problems/path-with-minimum-effort
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 *
 * S1: Use binary search template
 * S2: If you are given k, check if it is possible to go to (row-1, col-1) with k effort
 * S2: Min effort is 0, max effort is maxValue - minValue, use binary search to find k
 *
 * Time: O(m * n * log(k)), k is maxVal - minVal
 * Space: O(m * n)
 */
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        int lo = 0;
        int hi;
        int mid;
        int minVal = Integer.MAX_VALUE;
        int maxVal = 0;
        for (int[] height : heights) {
            for (int i = 0; i < columns; i++) {
                minVal = Math.min(height[i], minVal);
                maxVal = Math.max(height[i], maxVal);
            }
        }
        hi = maxVal - minVal;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (tryAbsoluteDiff(heights, rows, columns, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean tryAbsoluteDiff(int[][] heights, int rows, int columns, int k) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        boolean[][] visited = new boolean[rows][columns];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});
        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int r = pos[0];
            int c = pos[1];
            if (r == rows - 1 && c == columns - 1) {
                return true;
            }
            if (!visited[r][c]) {
                visited[r][c] = true;
                for (int i = 0; i < 4; i++) {
                    int newr = r + dr[i];
                    int newc = c + dc[i];
                    if (newr >= 0 && newr < rows && newc >= 0 && newc < columns && !visited[newr][newc]
                            && Math.abs(heights[newr][newc] - heights[r][c]) <= k) {
                        stack.push(new int[]{newr, newc});
                    }
                }
            }
        }
        return false;
    }
}
