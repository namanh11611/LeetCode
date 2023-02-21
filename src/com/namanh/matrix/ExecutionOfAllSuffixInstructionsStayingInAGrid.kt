package com.namanh.matrix

/**
 * https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid
 * There is an n x n grid. You are given the an integer array startPos where startPos = [startrow, startcol] indicates
 * that a robot is initially at cell (startrow, startcol). You are also given a 0-indexed string s of length m where
 * s[i] is the ith instruction for the robot: 'L' (move left), 'R' (move right), 'U' (move up), and 'D' (move down).
 * The robot can begin executing from any ith instruction in s. It executes the instructions one by one towards the end
 * of s but it stops if either of these conditions is met:
 * - The next instruction will move the robot off the grid.
 * - There are no more instructions left to execute.
 * Return an array answer of length m where answer[i] is the number of instructions the robot can execute if the robot
 * begins executing from the ith instruction in s.
 *
 * S1: Iterate from end to start of string, imagine it start from this coordinator
 * S2: Each step, find the position it go outside of matrix
 *
 * Time: O(m)
 * Space: O(m)
 */
object ExecutionOfAllSuffixInstructionsStayingInAGrid {
    fun executeInstructions(n: Int, startPos: IntArray, s: String): IntArray {
        val m = s.length
        val result = mutableListOf<Int>()
        val xMap = HashMap<Int, Int>()
        val yMap = HashMap<Int, Int>()
        var x = 0
        var y = 0
        for (i in m - 1 downTo 0) {
            xMap[x] = i
            yMap[y] = i
            when (s[i]) {
                'L' -> y++
                'R' -> y--
                'U' -> x++
                'D' -> x--
            }
            val deltaXStart = x - startPos[0]
            val deltaYStart = y - startPos[1]
            val minX = minOf(
                xMap[deltaXStart - 1] ?: m,
                xMap[n + deltaXStart] ?: m
            )
            val minY = minOf(
                yMap[deltaYStart - 1] ?: m,
                yMap[n + deltaYStart] ?: m
            )
            result.add(0, minOf(minX, minY) - i)
        }
        return result.toIntArray()
    }
}