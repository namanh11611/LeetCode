package com.namanh.math

/**
 * https://leetcode.com/problems/minimum-operations-to-make-array-equal
 * You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e., 0 <= i < n).
 * In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to
 * arr[y]. The goal is to make all the elements of the array equal.
 * Given an integer n, the length of the array, return the minimum number of operations needed to make all the elements
 * of arr equal.
 *
 * S1: First element: 1, last element: 2n-1, number operations to make first = last is n-1
 * S2: In case n % 2 == 0: total operations = (n-1) + (n-3) + ... + 1
 *     Result = n * n / 4
 * S3: In case n % 2 == 1: total operations = (n-1) + (n-3) + ... + 0
 *     Result = (n * n - 1) / 4
 *     When we return Int, it will be rounded = n * n / 4
 *
 * Time: O(1)
 * Space: O(1)
 */
class MinimumOperationsToMakeArrayEqual {
    fun minOperations(n: Int): Int {
        return n * n / 4
    }
}