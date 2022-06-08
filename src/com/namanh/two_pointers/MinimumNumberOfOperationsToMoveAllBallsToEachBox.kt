package com.namanh.two_pointers

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty,
 * and '1' if it contains one ball. In one operation, you can move one ball from a box to an adjacent box.
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls
 * to the ith box.
 *
 * S1: Use 2 pointers to store number of '1' box
 * S2: Calculate value for the first box, it's total of distance of all '1' boxes to the first box
 * S3: Browser the boxes string, update left and right pointer
 * S4: Value = previous value + left pointer - right pointer
 *
 * Time: O(n)
 * Space: O(1)
 */
class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    fun minOperations(boxes: String): IntArray {
        var numLeftDigit = boxes[0] - '0'
        var numRightDigit = 0
        val result = IntArray(boxes.length)
        for (i in 1 until boxes.length) {
            if (boxes[i] > '0') {
                numRightDigit++
                result[0] += i
            }
        }

        for (i in 1 until boxes.length) {
            result[i] = result[i-1] + numLeftDigit - numRightDigit
            numLeftDigit += boxes[i] - '0'
            numRightDigit -= boxes[i] - '0'
        }
        return result
    }
}