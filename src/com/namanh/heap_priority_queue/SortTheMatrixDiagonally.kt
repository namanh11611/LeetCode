package com.namanh.heap_priority_queue

import java.util.PriorityQueue
import kotlin.collections.HashMap

/**
 * https://leetcode.com/problems/sort-the-matrix-diagonally
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column
 * and going in the bottom-right direction until reaching the matrix's end.
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
 *
 * S1: All cells in diagonal line have same i-j value
 * S2: Create a HashMap with key = i-j, value = PriorityQueue to store all cells in diagonal line
 * S3: Iterate matrix and assign value from PriorityQueue
 *
 * Time: O(m * n * log(min(m,n)))
 * Space: O(m * n)
 */
class SortTheMatrixDiagonally {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        val ascMap = HashMap<Int, PriorityQueue<Int>>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                ascMap.putIfAbsent(i - j, PriorityQueue<Int>())
                ascMap[i - j]?.offer(mat[i][j])
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                mat[i][j] = ascMap[i - j]?.poll() ?: 0
            }
        }
        return mat
    }
}