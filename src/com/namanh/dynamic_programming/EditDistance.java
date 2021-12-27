package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/edit-distance
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * - Insert a character
 * - Delete a character
 * - Replace a character
 *
 * S1: Fill value for first row and first column
 * S2: If word1[i] == word2[j], result[i][j] = result[i - 1][j - 1]
 * S3: Otherwise, find min in 3 cases:
 *     - Insert: result[i][j] = result[i - 1][j] + 1
 *     - Delete: result[i][j] = result[i][j - 1] + 1
 *     - Replace: result[i][j] = result[i - 1][j - 1] + 1
 * S4: Return result[n1][n2]
 *
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] result = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            result[i][0] = i;
        }
        for (int i = 1; i <= n2; i++) {
            result[0][i] = i;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]);
                    result[i][j] = Math.min(result[i][j], result[i - 1][j - 1]) + 1;
                }
            }
        }
        return result[n1][n2];
    }
}
