package com.namanh.heap_priority_queue

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/ipo
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is
 * needed to start it. Initially, you have w capital. When you finish a project, you will obtain its pure profit and the
 * profit will be added to your total capital. Pick a list of at most k distinct projects from given projects to
 * maximize your final capital, and return the final maximized capital.
 *
 * S1: Create 2 queues to store profit in descending order, capital in ascending order
 * S2: Add all pairs into cQueue
 * S3: Each step, pop all pairs from cQueue satisfy capital < w, add into pQueue
 * S4: Add first element of pQueue
 *
 * Time: O(n * log(n))
 * Space: O(n)
 */
object IPO {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val pQueue = PriorityQueue<IntArray>(compareBy { -it[0] })
        val cQueue = PriorityQueue<IntArray>(compareBy { it[1] })
        for (i in profits.indices) {
            cQueue.add(intArrayOf(profits[i], capital[i]))
        }
        var curW = w
        for (i in 1..k) {
            while (cQueue.isNotEmpty()) {
                val q = cQueue.peek()
                if (q[1] <= curW) {
                    pQueue.offer(cQueue.poll())
                } else {
                    break
                }
            }
            if (pQueue.isNotEmpty()) {
                curW += pQueue.poll()[0]
            } else {
                return curW
            }
        }
        return curW
    }
}