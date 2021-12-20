package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number
 * The Tribonacci sequence Tn is defined as follows: T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * Given n, return the value of Tn.
 */
public class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        int t0 = 0, t1 = 1, t2 = 1, res = 0;
        for (int i = 3; i <= n; i++) {
            res = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = res;
        }
        return res;
    }
}
