package com.namanh.matrix;

/**
 * https://leetcode.com/problems/rotate-image
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[21][21];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix[n-j-1][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
