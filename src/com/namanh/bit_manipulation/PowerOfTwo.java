package com.namanh.bit_manipulation;

/**
 * https://leetcode.com/problems/power-of-two
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
