package com.namanh.array

/**
 * https://leetcode.com/problems/can-place-flowers
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be
 * planted in adjacent plots.
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
 * return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 *
 * S1: Check left and right plot
 *
 * Time: O(n)
 * Space: O(1)
 */
object CanPlaceFlowers {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        val size = flowerbed.size
        var maxPlot = 0
        for (i in flowerbed.indices) {
            if ((i == 0 || flowerbed[i - 1] == 0) && (i == size - 1 || flowerbed[i + 1] == 0) && flowerbed[i] == 0) {
                flowerbed[i] = 1
                maxPlot++
            }
        }
        return n <= maxPlot
    }
}