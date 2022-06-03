package com.namanh.string;

/**
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 * Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary
 * numbers needed so that they sum up to n.
 *
 * S1: Iterate string, find the maximum integer
 *
 * Time: O(n)
 * Space: O(1)
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public int minPartitions(String n) {
        int result = 0;
        int length = n.length();
        for (int i = 0; i < length; i++) {
            int c = n.charAt(i) - '0';
            result = Math.max(result, c);
        }
        return result;
    }

    public int minPartitions1(String n) {
        for (int i = 9; i > 0; i--) {
            if (n.contains(String.valueOf(i))) return i;
        }
        return 0;
    }
}
