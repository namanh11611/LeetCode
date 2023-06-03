package com.namanh.math

/**
 * https://leetcode.com/problems/design-parking-system
 */
class ParkingSystem(big: Int, medium: Int, small: Int) {

    private var slot: IntArray

    init {
        slot = intArrayOf(big, medium, small)
    }

    fun addCar(carType: Int): Boolean {
        if (slot[carType - 1] <= 0) return false
        slot[carType - 1]--
        return true
    }

}