package com.namanh.binary_search;

/**
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size
 * You have a sorted array of unique elements and an unknown size. You are also given an integer target.
 * Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
 *
 * S1: Find the minimum high index, which have value greater target
 * S2: Set low is high / 2
 * S3: Use binary search on [low, high]
 */
public class SearchInASortedArrayOfUnknownSize {
    interface ArrayReader {
        default int get(int index) {
            return Integer.MAX_VALUE;
        }
    }
    public int search(ArrayReader reader, int target) {
        int hi = 1;
        while (reader.get(hi) < target) {
            hi = hi << 1;
        }
        int lo = hi >> 1;
        int mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (reader.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return reader.get(lo) == target ? lo : -1;
    }
}
