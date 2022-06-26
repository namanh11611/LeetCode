package com.namanh.bit_manipulation

/**
 * https://leetcode.com/problems/sum-of-two-integers
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 *      0 1 0 1
 *      0 1 1 0
 * Xor: 0 0 1 1
 * And: 0 1 0 0 -> Shift left: 1 0 0 0
 *
 * S1: Use recursion solution
 * S2: Calculate of a xor b and (a and b) shift left 1
 *
 * Time: O(n)
 * Space: O(1)
 */
class SumOfTwoIntegers {
    fun getSum(a: Int, b: Int): Int {
        return if (b == 0) a else getSum(a xor b, (a and b) shl 1)
    }
}