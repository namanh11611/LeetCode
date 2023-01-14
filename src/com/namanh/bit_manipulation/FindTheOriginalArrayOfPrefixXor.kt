package com.namanh.bit_manipulation

/**
 * https://leetcode.com/problems/find-the-original-array-of-prefix-xor
 * You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:
 * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 *
 * S1: Similar prefix sum: pref[i] = pref[i-1] ^ arr[i]
 * S2:  a = b ^ c
 *      a ^ a ^ c = (b ^ c) ^ a ^ c
 *      (a ^ a) ^ c = (a ^ b) ^ (c ^ c) (Xor have associative and commutative)
 *      c = a ^ b (because a ^ a = 0)
 *      So, arr[i] = pref[i] ^ pref[i-1]
 *
 * Time: O(n)
 * Space: O(n)
 */
class FindTheOriginalArrayOfPrefixXor {
    fun findArray(pref: IntArray): IntArray {
        val arr = IntArray(pref.size)
        arr[0] = pref[0]
        for (i in 1 until pref.size) {
            arr[i] = pref[i] xor pref[i-1]
        }
        return arr
    }
}