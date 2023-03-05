package com.namanh.bfs

import java.util.*
import kotlin.collections.HashMap

/**
 * https://leetcode.com/problems/jump-game-iv
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 * In one step you can jump from index i to index:
 * - i + 1 where: i + 1 < arr.length.
 * - i - 1 where: i - 1 >= 0.
 * - j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 */
object JumpGameIV {
    fun minJumps(arr: IntArray): Int {
        val n = arr.size
        val map = HashMap<Int, MutableList<Int>>()
        for (i in arr.indices) {
            map.getOrPut(arr[i]) { mutableListOf() }.add(i)
        }
        val queue = LinkedList<Int>()
        queue.offer(0)
        val visited = BooleanArray(n)
        visited[0] = true
        var step = 0
        while (queue.isNotEmpty()) {
            for (i in 1..queue.size) {
                val node = queue.poll()
                if (node == n - 1) return step
                val adjList = map.getOrDefault(arr[node], mutableListOf())
                adjList.add(node - 1)
                adjList.add(node + 1)
                for (adj in adjList) {
                    if (adj in 0 until n && !visited[adj]) {
                        queue.offer(adj)
                        visited[adj] = true
                    }
                }
                adjList.clear()
            }
            step++
        }
        return 0
    }
}