package com.namanh.binary_search

/**
 * https://leetcode.com/problems/kth-missing-positive-number
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * Return the kth positive integer that is missing from this array.
 *
 * S1: If arr[0] > k, missing number is before this array
 * S2: If arr[n - 1] - (n - 1) <= k, missing number is after this array
 * S3: Otherwise, use binary search to find the first position satisfy arr[i] - i > k
 *
 * Time: O(log(n))
 * Space: O(1)
 */
object KthMissingPositiveNumber {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        if (arr[0] > k) return k
        val n = arr.size
        if (arr[n - 1] - n + 1 <= k) return n + k
        var start = 0
        var end = n - 1
        while (start < end) {
            val mid = start + (end - start) / 2
            if (arr[mid] - mid > k) {
                end = mid
            } else {
                start = mid + 1
            }
        }
        return start + k
    }
}