package com.namanh.string;

/**
 * https://leetcode.com/problems/count-binary-substrings
 * Give a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all
 * the 0's and all the 1's in these substrings are grouped consecutively.
 *
 * ..... 0 0 0 0  1 1 1 1 .....
 *       length1  length2
 * S1: Use length1 and length2 to store length of 2 substring only contains 0 or 1
 * S2: Compare current character and previous character
 *     - If same, increase length2
 *     - If different, set length1 = length2 and reset length2
 * S3: If length2 less than or equal length1, increase result
 *
 * Time: O(n)
 * Space: O(1)
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int length1 = 0, length2 = 1, result = 0;
        int n = s.length();
        char c1, c2 = s.charAt(0);
        for (int i = 1; i < n; i++) {
            c1 = c2;
            c2 = s.charAt(i);
            if (c1 == c2) {
                length2++;
            } else {
                length1 = length2;
                length2 = 1;
            }
            if (length2 <= length1) result++;
        }
        return result;
    }
}
