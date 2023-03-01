package com.namanh.sort

/**
 * https://leetcode.com/problems/sort-an-array
 * Given an array of integers nums, sort the array in ascending order and return it.
 *
 * S1: Quick sort
 *
 * Time: O(n * log(n))
 * Space: O(log(n))
 */
object SortAnArray {
    fun sortArray(nums: IntArray): IntArray {
        quickSort(nums, 0, nums.size - 1)
        return nums
    }

    private fun quickSort(nums: IntArray, start: Int, end: Int) {
        if (start < end) {
            val index = partition(nums, start, end)
            quickSort(nums, start, index - 1)
            quickSort(nums, index + 1, end)
        }
    }

    private fun partition(nums: IntArray, start: Int, end: Int): Int {
        val pivot = nums[end]
        var left = start
        var right = end - 1
        while (left <= right) {
            while (left <= right && nums[left] <= pivot) left++
            while (left <= right && nums[right] > pivot) right--
            if (left >= right) break
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
            right--
        }
        nums[end] = nums[left]
        nums[left] = pivot
        return left
    }
}