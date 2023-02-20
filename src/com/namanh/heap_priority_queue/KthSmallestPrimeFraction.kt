package com.namanh.heap_priority_queue

import java.util.*

/**
 * https://leetcode.com/problems/k-th-smallest-prime-fraction
 * You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique.
 * You are also given an integer k.
 * For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
 * Return the kth smallest fraction considered.
 *
 * S1: Use heap to store int array, compare by fraction
 * S2: Initialize, we only store all fraction with same numerator, different denominator
 * S3: Remove k times, continue adding new fraction with new numerator
 */
object KthSmallestPrimeFraction {
    /**
     * Optimized
     * Time: O(k * log(n))
     * Space: O(n)
     */
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val n = arr.size
        val heap = PriorityQueue<IntArray> { a, b ->
            arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]]
        }
        for (i in 1 until n) {
            heap.offer(intArrayOf(0, i))
        }
        for (i in 1 until k) {
            val index = heap.poll()
            if (index[0] + 1 < index[1]) {
                heap.offer(intArrayOf(index[0] + 1, index[1]))
            }
        }
        val result = heap.poll()
        return intArrayOf(arr[result[0]], arr[result[1]])
    }

    /**
     * Straightforward
     * Time: O(n^2 * log(n))
     * Space: O(n^2)
     */
    fun kthSmallestPrimeFraction1(arr: IntArray, k: Int): IntArray {
        val n = arr.size
        val heap = PriorityQueue<IntArray> { a, b ->
            a[0] * b[1] - b[0] * a[1]
        }
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                heap.offer(intArrayOf(arr[i], arr[j]))
            }
        }
        for (i in 1 until k) {
            heap.poll()
        }
        return heap.poll()
    }
}