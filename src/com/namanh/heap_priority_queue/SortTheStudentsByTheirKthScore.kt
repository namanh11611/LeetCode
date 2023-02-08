package com.namanh.heap_priority_queue

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/sort-the-students-by-their-kth-score
 * There is a class with m students and n exams. You are given a 0-indexed m x n integer matrix score, where each row
 * represents one student and score[i][j] denotes the score the ith student got in the jth exam. The matrix score
 * contains distinct integers only.
 * You are also given an integer k. Sort the students by their scores in the kth exam from the highest to the lowest.
 * Return the matrix after sorting it.
 *
 * S1: Use heap to sort the score at kth index
 * S2: Assign value for score matrix
 *
 * Time: O(m * log(m))
 * Space: O(m)
 */
object SortTheStudentsByTheirKthScore {
    fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> {
        val m = score.size
        val heap = PriorityQueue<IntArray>(compareBy { it[k] })
        for (studentScore in score) {
            heap.offer(studentScore)
        }
        for (i in (m-1) downTo 0) {
            score[i] = heap.poll()
        }
        return score
    }
}