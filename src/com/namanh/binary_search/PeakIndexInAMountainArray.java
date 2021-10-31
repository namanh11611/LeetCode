package com.namanh.binary_search;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array
 * Q: Given an integer array arr that is guaranteed to be a mountain, return any i such that
 * arr[0] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 *
 * S1: The comparison arr[i] < arr[i + 1] is an array look like [true, true, ..., true, false, ..., false]
 * S2: If arr[mid] < arr[mid + 1] => arr[mid] isn't satisfied => low = mid + 1
 * S3: If arr[mid] > arr[mid + 1] => arr[mid] maybe is result, so we keep arr[mid] => high = mid
 * S4: When only have 2 or 3 element, low is result
 *     Don't use condition lo <= hi => maybe cause infinite loop
 */
public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] < arr[mid+1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (mid == 0 || mid == n || (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])) {
                return mid;
            }
            if (arr[mid] > arr[mid-1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return mid;
    }
}
