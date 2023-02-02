package com.namanh.matrix

/**
 * https://leetcode.com/problems/number-of-laser-beams-in-a-bank
 * Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string array bank
 * representing the floor plan of the bank, which is an m x n 2D matrix.
 * There is one laser beam between any two security devices if both conditions are met:
 * - The two devices are located on two different rows: r1 and r2, where r1 < r2.
 * - For each row i where r1 < i < r2, there are no security devices in the ith row.
 * Return the total number of laser beams in the bank.
 *
 * S1: Iterate each row, count number security devices
 * S2: If current number different 0, add current number multiple previous number
 *
 * Time: O(m * n)
 * Space: O(1)
 */
class NumberOfLaserBeamsInABank {
    fun numberOfBeams(bank: Array<String>): Int {
        var result = 0
        var numPrevDevice = 0
        var numCurDevice: Int
        for (row in bank) {
            numCurDevice = row.count {
                it == '1'
            }
            if (numCurDevice != 0) {
                result += numPrevDevice * numCurDevice
                numPrevDevice = numCurDevice
            }
        }
        return result
    }
}