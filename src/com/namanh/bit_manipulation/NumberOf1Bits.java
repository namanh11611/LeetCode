package com.namanh.bit_manipulation;

/**
 * https://leetcode.com/problems/number-of-1-bits
 * Returns the number of '1' bits
 *
 * If          n = 111000...000
 * then      n-1 = 110111...111
 * So, n & (n-1) = 110000...000 -> we removed last 1 digit
 * Repeat until n = 0, return counter
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int number = 0;
        while (n != 0) {
            n = n & (n - 1);
            number++;
        }
        return number;
    }
}
