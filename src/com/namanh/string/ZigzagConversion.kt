package com.namanh.string

/**
 * https://leetcode.com/problems/zigzag-conversion
 * The string "ABCDEFGHIJKLMNOPQRSTUVWXYZ" is written in a zigzag pattern on a given number of rows like this:
 * A    G    M    S    Y
 * B  F H  L N  R T  X Z
 * C E  I K  O Q  U W
 * D    J    P    V
 * And then read line by line: "AGMSYBFHLNRTXZCEIKOQUWDJPV"
 * Write the code that will take a string and make this conversion given a number of rows
 *
 * S1: Calculate size of group: 2n - 2
 *     i = 0: A
 *     i = 1: B  F
 *     i = 2: C E
 *     i = 3: D
 * S2: Iterate each row i, j is real index
 * S3: If it's first or last row, only add 1 element
 * S4: If it's middle row, calculate the second index
 *     L[index] = G[index] + grSize - i
 *              = j - i + grSize - i
 *              = j + grSize - 2 * i
 *
 * Time: O(n)
 * Space: O(1)
 */
object ZigzagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        var result = ""
        val grSize = 2 * numRows - 2
        for (i in 0 until numRows) {
            var j = i
            while (j < s.length) {
                if (j % grSize == 0 || j % grSize == numRows - 1) {
                    result += s.elementAt(j)
                } else {
                    result += s.elementAt(j)
                    val secondIdx = j + grSize - 2 * i
                    if (secondIdx < s.length) {
                        result += s.elementAt(secondIdx)
                    }
                }
                j += grSize
            }
        }
        return result
    }
}