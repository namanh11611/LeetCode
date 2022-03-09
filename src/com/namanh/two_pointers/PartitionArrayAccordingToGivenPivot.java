package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/partition-array-according-to-given-pivot
 * You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions
 * are satisfied:
 * - Every element less than pivot appears before every element greater than pivot.
 * - Every element equal to pivot appears in between the elements less than and greater than pivot.
 * - The relative order of the elements less than pivot and the elements greater than pivot is maintained.
 *
 * S1: Find the number of smaller than and equal pivot element
 * S2: Iterate and save element to result array
 *
 * Time: O(n)
 * Space: O(n)
 */
public class PartitionArrayAccordingToGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length, smallerNum = 0, equalNum = 0;
        int[] result = new int[n];
        for (int num : nums) {
            if (num < pivot) smallerNum++;
            else if (num == pivot) equalNum++;
        }
        int smallerIdx = 0, equalIdx = smallerNum, greaterIdx = smallerNum + equalNum;
        for (int num : nums) {
            if (num < pivot) {
                result[smallerIdx++] = num;
            } else if (num > pivot) {
                result[greaterIdx++] = num;
            } else {
                result[equalIdx++] = num;
            }
        }
        return result;
    }
}
