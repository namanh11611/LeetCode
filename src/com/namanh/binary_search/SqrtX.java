package com.namanh.binary_search;

/**
 * https://leetcode.com/problems/sqrtx
 * Q: Given a non-negative integer x, compute and return the square root of x.
 *
 * S1: Apply binary search template
 *      F F F F F T T T T
 *              |
 *             mid < sqrt(x)
 * S2: So, we need return lo - 1
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int lo = 0;
        int hi = x;
        int mid;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (x / mid < mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }
}
