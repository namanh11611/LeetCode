package com.namanh.bfs

import java.util.LinkedList
import kotlin.collections.HashSet

/**
 * https://leetcode.com/problems/open-the-lock
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6',
 * '7', '8', '9'. The lock initially starts at '0000'. You are given a list of deadends dead ends, meaning if the lock
 * displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of
 * turns required to open the lock, or -1 if it is impossible.
 *
 * S1: Use BFS to find minimum number turn
 *
 * Time: O(n)
 * Space: O(n)
 */
object OpenTheLock {
    fun openLock(deadends: Array<String>, target: String): Int {
        if (target == "0000") return 0
        val deadendsSet = deadends.toSet()
        if (deadendsSet.contains("0000")) return -1

        val queue = LinkedList<String>()
        queue.offer("0000")
        val visited = HashSet<String>()
        visited.add("0000")
        var step = 1

        fun isFoundTarget(pass: String): Boolean {
            if (!visited.contains(pass)) {
                visited.add(pass)
                if (pass == target) return true
                if (!deadendsSet.contains(pass)) {
                    queue.offer(pass)
                }
            }
            return false
        }

        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 1..size) {
                val sb = StringBuilder(queue.poll())
                for (k in 0..3) {
                    val c = sb[k]
                    sb[k] = if (c == '0') '9' else c - 1
                    if (isFoundTarget(sb.toString())) return step

                    sb[k] = if (c == '9') '0' else c + 1
                    if (isFoundTarget(sb.toString())) return step
                    sb[k] = c
                }
            }
            step++
        }

        return -1
    }
}
