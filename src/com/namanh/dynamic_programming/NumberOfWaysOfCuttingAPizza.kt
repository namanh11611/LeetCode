package com.namanh.dynamic_programming

/**
 * https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza
 * Given a rectangular pizza represented as a rows x cols matrix containing the following characters: 'A' (an apple) and
 * '.' (empty cell) and given the integer k. You have to cut the pizza into k pieces using k-1 cuts. For each cut you
 * choose the direction: vertical or horizontal, then you choose a cut position at the cell boundary and cut the pizza
 * into two pieces. If you cut the pizza vertically, give the left part of the pizza to a person. If you cut the pizza
 * horizontally, give the upper part of the pizza to a person. Give the last piece of pizza to the last person.
 * Return the number of ways of cutting the pizza such that each piece contains at least one apple. Since the answer can
 * be a huge number, return this modulo 10^9 + 7.
 *
 * Time: O(k * n * m * (n + m))
 * Space: O(n * m)
 */
object NumberOfWaysOfCuttingAPizza {
    fun ways(pizza: Array<String>, k: Int): Int {
        val rows = pizza.size
        val cols = pizza[0].length
        val apples = Array(rows + 1) { IntArray(cols + 1) }
        var numberCut = Array(rows) { IntArray(cols) }
        for (row in rows - 1 downTo 0) {
            for (col in cols - 1 downTo 0) {
                apples[row][col] =
                    (if (pizza[row][col] == 'A') 1 else 0) + apples[row + 1][col] + apples[row][col + 1] - apples[row + 1][col + 1]
                numberCut[row][col] = if (apples[row][col] > 0) 1 else 0
            }
        }
        val mod = 1_000_000_007
        for (remain in 1 until k) {
            val nCut = Array(rows) { IntArray(cols) }
            for (row in 0 until rows) {
                for (col in 0 until cols) {
                    for (nextRow in row + 1 until rows) {
                        if (apples[row][col] - apples[nextRow][col] > 0) {
                            nCut[row][col] += numberCut[nextRow][col]
                            nCut[row][col] %= mod
                        }
                    }
                    for (nextCol in col + 1 until cols) {
                        if (apples[row][col] - apples[row][nextCol] > 0) {
                            nCut[row][col] += numberCut[row][nextCol]
                            nCut[row][col] %= mod
                        }
                    }
                }
            }
            numberCut = nCut
        }
        return numberCut[0][0]
    }
}