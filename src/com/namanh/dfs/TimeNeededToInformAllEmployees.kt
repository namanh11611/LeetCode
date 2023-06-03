package com.namanh.dfs

/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees
 *
 * S1: Build graph
 * S2: Use DFS to find the maximum child tree
 *
 * Time: O(n)
 * Space: O(n)
 */
object TimeNeededToInformAllEmployees {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }
        for (i in 0 until n) {
            if (manager[i] != -1) {
                graph[manager[i]].add(i)
            }
        }
        fun dfs(index: Int): Int {
            var maxTime = 0
            for (i in graph[index]) {
                maxTime = maxOf(maxTime, dfs(i))
            }
            return informTime[index] + maxTime
        }
        return dfs(headID)
    }
}
