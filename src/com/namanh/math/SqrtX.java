package com.namanh.math;

/**
 * https://leetcode.com/problems/sqrtx
 * Q: Given a non-negative integer x, compute and return the square root of x.
 */
public class SqrtX {
    public int mySqrt(int x) {
        int lo = 0;
        int hi = 46340; // sqrt of integer max value
        int mid;
        int res = 0;
        int midSq;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            midSq = mid * mid;
            if (midSq == x) {
                return mid;
            } else if (midSq < x) {
                lo = mid + 1;
                res = mid;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}
