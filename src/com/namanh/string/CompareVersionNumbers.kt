package com.namanh.string

/**
 * https://leetcode.com/problems/compare-version-numbers
 * Given two version numbers, version1 and version2, compare them.
 *
 * Time: O(n)
 * Space: O(n)
 */
object CompareVersionNumbers {
    fun compareVersion(version1: String, version2: String): Int {
        val arr1 = version1.split('.').map { it.toInt() }
        val arr2 = version2.split('.').map { it.toInt() }
        val size1 = arr1.size
        val size2 = arr2.size
        for (i in 0 until maxOf(size1, size2)) {
            val v1 = if (i < size1) arr1[i] else 0
            val v2 = if (i < size2) arr2[i] else 0
            if (v1 < v2) {
                return -1
            } else if (v1 > v2) {
                return 1
            }
        }
        return 0
    }
}
