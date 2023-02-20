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
 *
 * Time: O(n^2 * log(n))
 * Space: O(n^2)
 */
object KthSmallestPrimeFraction {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val n = arr.size
        val heap = PriorityQueue<IntArray>(compareBy { 1F * it[0] / it[1] })
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