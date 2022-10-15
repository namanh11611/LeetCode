package com.namanh.math

import kotlin.math.log
import kotlin.math.pow

/**
 * https://leetcode.com/problems/strictly-palindromic-number
 * An integer n is strictly palindromic if, for every base b between 2 and n - 2 (inclusive), the string representation
 * of the integer n in base b is palindromic.
 * Given an integer n, return true if n is strictly palindromic and false otherwise.
 */
class StrictlyPalindromicNumber {
    /**
     * The short way
     * The number n in base (n - 2) is always 12, which is not palindromic.
     */
    fun isStrictlyPalindromic(n: Int): Boolean {
        return false
    }

    /**
     * The long way
     */
    fun isStrictlyPalindromic1(n: Int): Boolean {
        for (base in 2..n-2) {
            val numChar = log(n.toDouble(), base.toDouble()).toInt()
            var halfChar = numChar / 2 + 1
            var tempN = n
            val stack = ArrayDeque<Int>()
            for (i in numChar downTo halfChar) {
                val powI = base.toDouble().pow(i).toInt()
                stack.add(tempN / powI)
                tempN %= powI
            }
            halfChar--
            if (numChar % 2 == 0) {
                tempN %= base.toDouble().pow(halfChar).toInt()
                halfChar--
            }
            for (i in halfChar downTo 0) {
                val powI = base.toDouble().pow(i).toInt()
                if (stack.removeLast() != tempN / powI) {
                    return false
                }
                tempN %= powI
            }
        }
        return true;
    }
}