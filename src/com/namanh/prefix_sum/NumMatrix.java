package com.namanh.prefix_sum;

/**
 * Range Sum Query 2D - Immutable
 * https://leetcode.com/problems/range-sum-query-2d-immutable
 */
public class NumMatrix {
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            matrix[i][0] += matrix[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            matrix[0][j] += matrix[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int subBlock1 = row1 == 0 ? 0 : matrix[row1 - 1][col2];
        int subBlock2 = col1 == 0 ? 0 : matrix[row2][col1 - 1];
        int subBlock3 = row1 == 0 || col1 == 0 ? 0 : matrix[row1 - 1][col1 - 1];
        return matrix[row2][col2] - subBlock1 - subBlock2 + subBlock3;

        /* Use this to save memory
        return matrix[row2][col2] - (row1 == 0 ? 0 : matrix[row1 - 1][col2]) - (col1 == 0 ? 0 : matrix[row2][col1 - 1])
                + (row1 == 0 || col1 == 0 ? 0 : matrix[row1 - 1][col1 - 1]);
         */
    }
}
