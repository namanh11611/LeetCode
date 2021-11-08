package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/longest-mountain-in-array
 * Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is
 * no mountain subarray.
 *
 * S1: Remove all redundant element, which have a[i] >= a[i+1]
 * S2: Mark the start point, start climb the mountains a[i] < a[i+1]
 * S3: Mark the mount point
 * S4: Walk down a[i] > a[i+1]
 * S5: Check if current point > mount and mount > start, return length and compare with max
 *
 * Time: O(n)
 * Space: O(1)
 */
public class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        int max = 0;
        int n = arr.length - 1;
        int left, mount, i = 0;
        while (i < n) {
            while (i < n && arr[i] >= arr[i+1]) {
                i++;
            }
            left = i;
            while (i < n && arr[i] < arr[i+1]) {
                i++;
            }
            mount = i;
            while (i < n && arr[i] > arr[i+1]) {
                i++;
            }
            if (i > mount && mount > left) {
                max = Math.max(max, i - left + 1);
            }
        }
        return max;
    }
}
