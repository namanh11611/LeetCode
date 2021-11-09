package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the
 * following properties: Integers in each row/column are sorted in ascending.
 *
 * S1: Search from top/right to bottom/left or opposite
 *
 * Time: O(m + n)
 * Space: O(1)
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
