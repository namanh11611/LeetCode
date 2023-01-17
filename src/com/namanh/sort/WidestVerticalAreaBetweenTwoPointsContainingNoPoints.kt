package com.namanh.sort

/**
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points
 * Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that
 * no points are inside the area. A vertical area is an area of fixed-width extending infinitely along the y-axis
 * (i.e., infinite height). The widest vertical area is the one with the maximum width.
 *
 * S1: We can ignore y-axis and find the maximum distance between x-axis. So, sort array by x-axis
 * S2: Find the maximum distance
 *
 * Time: O(n * log(n))
 * Space: O(1)
 */
class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        points.sortBy { it[0] }
        var max = points[1][0] - points[0][0]
        for (i in 2 until points.size) {
            max = max.coerceAtLeast(points[i][0] - points[i - 1][0])
        }
        return max
    }
}