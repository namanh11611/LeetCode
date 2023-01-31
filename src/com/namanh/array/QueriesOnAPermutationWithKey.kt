package com.namanh.array

/**
 * https://leetcode.com/problems/queries-on-a-permutation-with-key
 * Given the array queries of positive integers between 1 and m, you have to process all queries[i]
 * (from i=0 to i=queries.length-1) according to the following rules:
 * - In the beginning, you have the permutation P=[1,2,3,...,m].
 * - For the current i, find the position of queries[i] in the permutation P (indexing from 0) and then move this at the
 * beginning of the permutation P. Notice that the position of queries[i] in P is the result for queries[i].
 * Return an array containing the result for the given queries.
 *
 * S1: Create an array with element from 1 to m
 * S2: Find index of element equals queries[i], add into result array
 * S3: Move all elements from 0 to index-1
 * S4: Assign array[0] = queries[i]
 *
 * Time: O(n^2)
 * Space: O(n)
 *
 * NOTE: Optimal solution is Fenwick Tree
 */
class QueriesOnAPermutationWithKey {
    fun processQueries(queries: IntArray, m: Int): IntArray {
        val arr = MutableList(m) {
            it + 1
        }
        val result = IntArray(queries.size)
        for ((idx, q) in queries.withIndex()) {
            val indexMatch = arr.indexOfFirst {
                it == q
            }
            result[idx] = indexMatch
            for (i in indexMatch downTo 1) {
                arr[i] = arr[i-1]
            }
            arr[0] = q
        }
        return result
    }
}