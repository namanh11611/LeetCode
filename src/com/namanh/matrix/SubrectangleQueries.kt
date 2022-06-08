package com.namanh.matrix

/**
 * https://leetcode.com/problems/subrectangle-queries
 * Implement the class SubrectangleQueries which receives a rows x cols rectangle as a matrix of integers in the
 * constructor and supports two methods:
 * 1. updateSubrectangle: updates all values with newValue in the subrectangle whose upper left coordinate is
 * (row1,col1) and bottom right coordinate is (row2,col2).
 * 2. getValue: returns the current value of the coordinate (row,col) from the rectangle.
 */
class SubrectangleQueries(var rectangle: Array<IntArray>) {

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        for (i in row1..row2) {
            for (j in col1..col2) {
                rectangle[i][j] = newValue
            }
        }
    }

    fun getValue(row: Int, col: Int) = rectangle[row][col]

}