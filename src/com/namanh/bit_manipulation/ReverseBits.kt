package com.namanh.bit_manipulation

/**
 * https://leetcode.com/problems/reverse-bits
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * S1: Each step, get the last bit of n, assign for result
 * S2: Shift left result and shift right n
 *
 * Time: O(1)
 * Space: O(1)
 */
class ReverseBits {
    fun reverseBits(n:Int):Int {
        var start = n
        var res = 0
        for (i in 1..32) {
            res = (res shl 1) + (start and 1)
            start = start shr 1
        }
        return res
    }
}