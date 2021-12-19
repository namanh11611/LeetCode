package com.namanh.binary_search;

/**
 * https://leetcode.com/problems/first-bad-version
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
 * ones to be bad.
 *
 * S1: Use binary search template
 *
 * Time: O(log(n))
 * Space: O(1)
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static final int BAD = 2;
    boolean isBadVersion(int version) {
        return version >= BAD;
    }
}
