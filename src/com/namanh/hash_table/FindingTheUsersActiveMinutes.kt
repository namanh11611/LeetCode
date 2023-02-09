package com.namanh.hash_table

/**
 * https://leetcode.com/problems/finding-the-users-active-minutes
 * You are given the logs for users' actions on LeetCode, and an integer k. The logs are represented by a 2D integer
 * array logs where each logs[i] = [IDi, timei] indicates that the user with IDi performed an action at the minute i.
 * You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number
 * of users whose UAM equals j. Return the array answer as described above.
 *
 * S1: Use HashSet to store the list of minutes user active
 * S2: Return array with index = set.size
 *
 * Time: O(n)
 * Space: O(n)
 */
object FindingTheUsersActiveMinutes {
    fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
        val result = IntArray(k)
        val map = HashMap<Int, HashSet<Int>>()
        for (log in logs) {
            val set = map.getOrDefault(log[0], HashSet())
            set.add(log[1])
            map[log[0]] = set
        }
        for (set in map.values) {
            result[set.size - 1]++
        }
        return result
    }
}