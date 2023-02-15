package com.namanh.array

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer
 * The array-form of an integer num is an array representing its digits in left to right order.
 * For example, for num = 1321, the array form is [1,3,2,1].
 * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 */
object AddToArrayFormOfInteger {
    fun addToArrayForm(num: IntArray, k: Int): List<Int> {
        var kOrigin = k
        val result = mutableListOf<Int>()
        var remain = 0
        for (i in num.size - 1 downTo 0) {
            val kNum = kOrigin % 10
            kOrigin /= 10
            val newNum = num[i] + kNum + remain
            result.add(newNum % 10)
            remain = newNum / 10
        }
        while (kOrigin > 0) {
            val kNum = kOrigin % 10
            kOrigin /= 10
            val newNum = kNum + remain
            result.add(newNum % 10)
            remain = newNum / 10
        }
        if (remain > 0) result.add(remain)
        return result.reversed()
    }
}