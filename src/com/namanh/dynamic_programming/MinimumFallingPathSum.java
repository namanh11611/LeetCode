package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly
 * below or diagonally left/right.
 *
 * S1: Find min value of 3 previous cell
 * S2: Return max value at last row
 *
 * Time: O(n^2)
 * Space: O(1)
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int prev = matrix[i-1][j];
                if (j > 0 && matrix[i-1][j-1] < prev) {
                    prev = matrix[i-1][j-1];
                }
                if (j < n-1 && matrix[i-1][j+1] < prev) {
                    prev = matrix[i-1][j+1];
                }
                matrix[i][j] += prev;
            }
        }

        for (int i = 0; i < n; i++) {
            result = Math.min(result, matrix[n-1][i]);
        }
        return result;
    }
}
