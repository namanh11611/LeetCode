package com.namanh.math

/**
 * https://leetcode.com/problems/check-if-it-is-a-straight-line
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check
 * if these points make a straight line in the XY plane.
 *
 * S1: A straight line has formal: y = a * x + b
 * S2: Find a, b, c to: c * y = a * x + b
 *
 * Time: O(n)
 * Space: O(1)
 */
object CheckIfItIsAStraightLine {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        if (coordinates.size == 2) return true
        val point0 = coordinates[0]
        val point1 = coordinates[1]
        val a = point0[1] - point1[1]
        val c = point0[0] - point1[0]
        val b = c * point0[1] - a * point0[0]
        for (i in 2 until coordinates.size) {
            if (a * coordinates[i][0] + b != c * coordinates[i][1]) {
                return false
            }
        }
        return true
    }
}