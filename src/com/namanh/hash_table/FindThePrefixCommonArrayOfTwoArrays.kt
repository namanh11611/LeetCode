package com.namanh.hash_table

/**
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays
 * You are given two 0-indexed integer permutations A and B of length n. A prefix common array of A and B is an array C
 * such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.
 * Return the prefix common array of A and B.
 *
 * S1: Create 2 HashSet to store previous elements
 * S2: If A[i] == B[i], increase counter +1
 * S3: Otherwise, check if HashSet contains A[i] or B[i] to increase counter
 *
 * Time: O(n)
 * Space: O(n)
 */
object FindThePrefixCommonArrayOfTwoArrays {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val n = A.size
        val result = IntArray(n)
        if (A[0] == B[0]) result[0] = 1
        val setA = mutableSetOf(A[0])
        val setB = mutableSetOf(B[0])
        for (i in 1 until n) {
            setA.add(A[i])
            setB.add(B[i])
            result[i] = result[i - 1]
            if (A[i] == B[i]) {
                result[i]++
            } else {
                if (setB.contains(A[i])) result[i]++
                if (setA.contains(B[i])) result[i]++
            }
        }
        return result
    }
}