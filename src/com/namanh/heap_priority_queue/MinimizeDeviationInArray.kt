package com.namanh.heap_priority_queue

import java.util.*

/**
 * https://leetcode.com/problems/minimize-deviation-in-array
 * You are given an array nums of n positive integers.
 * You can perform two types of operations on any element of the array any number of times:
 * - If the element is even, divide it by 2.
 * - If the element is odd, multiply it by 2.
 * The deviation of the array is the maximum difference between any two elements in the array.
 * Return the minimum deviation the array can have after performing some number of operations.
 *
 * S1: Increase all odd elements, make it become even, store in a heap
 * S2: Divide all even elements, update min and result
 *
 * Time: O(n * log(n))
 * Space: O(n)
 */
object MinimizeDeviationInArray {
    fun minimumDeviation(nums: IntArray): Int {
        val queue = PriorityQueue<Int> { a, b -> b - a }
        var min = Int.MAX_VALUE
        for (n in nums) {
            val num = if (n and 1 == 0) n else n shl 1
            queue.offer(num)
            min = minOf(min, num)
        }

        var result = queue.peek() - min
        while (queue.peek() and 1 == 0) {
            val num = queue.poll() shr 1
            min = minOf(min, num)
            queue.offer(num)
            result = minOf(result, queue.peek() - min)
        }
        return result
    }
}