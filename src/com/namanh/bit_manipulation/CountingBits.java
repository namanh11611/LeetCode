package com.namanh.bit_manipulation;

/**
 * https://leetcode.com/problems/counting-bits
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of
 * 1's in the binary representation of i.
 */
public class CountingBits {
    /**
     * Refer {@link NumberOf1Bits}
     * i & (i-1) will remove last 1 digit
     * So, result[i] = result[i & (i-1)] + 1;
     */
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i & (i-1)] + 1;
        }
        return result;
    }

    /**
     * i >> 1 will remove last digit
     * i & 1 will return last digit is 0 or 1
     */
    public int[] countBits2(int n) {
        int[] result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
