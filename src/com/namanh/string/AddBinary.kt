package com.namanh.string

/**
 * https://leetcode.com/problems/add-binary
 * Given two binary strings a and b, return their sum as a binary string.
 */
object AddBinary {
    fun addBinary(a: String, b: String): String {
        var short = ""
        var long = ""
        if (a.length < b.length) {
            short = a
            long = b
        } else {
            short = b
            long = a
        }
        val ans = long.toCharArray()
        val delta = long.length - short.length
        var remain = 0
        for (i in short.length - 1 downTo 0) {
            if ((short[i] == '1' && remain == 0) || (short[i] == '0' && remain == 1)) {
                ans[i + delta] = if (long[i + delta] == '0') '1' else '0'
                remain = long[i + delta] - '0'
            }
        }
        if (remain == 1) {
            for (i in delta - 1 downTo 0) {
                if (long[i] == '0') {
                    ans[i] = '1'
                    remain = 0
                    break
                } else {
                    ans[i] = '0'
                }
            }
        }
        if (remain == 1) {
            return String(CharArray(long.length + 1) {
                if (it == 0) '1' else ans[it - 1]
            })
        }
        return String(ans)
    }
}