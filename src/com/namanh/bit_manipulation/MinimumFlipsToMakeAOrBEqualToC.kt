package com.namanh.bit_manipulation

/**
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make (a OR b == c)
 *
 * S1: Count if (lastA or lastB) != lastC
 *
 * Time: O(n)
 * Space: O(1)
 */
object MinimumFlipsToMakeAOrBEqualToC {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        var x = a
        var y = b
        var z = c
        var result = 0
        while (x != 0 || y != 0 || z != 0) {
            val lastX = x and 1
            val lastY = y and 1
            val lastZ = z and 1
            result += ((lastX or lastY) xor lastZ)
            if (lastX == 1 && lastY == 1 && lastZ == 0) result++
            x = x shr 1
            y = y shr 1
            z = z shr 1
        }
        return result
    }
}