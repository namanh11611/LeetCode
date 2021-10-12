package com.namanh.quick_select;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 * B1: Apply quick sort by descending to select
 * B2.1: If pivot < k-1, continue quick sort right array
 * B2.2: If pivot > k-1, continue quick sort left array
 * B2.3: If pivot == k-1, return nums[pivot]
 */
public class KthLargestElement {
    int[] mNums;

    public int findKthLargest(int[] nums, int k) {
        mNums = nums;
        int pivot;
        int start = 0, end = nums.length - 1;
        do {
            pivot = quickSelect(start, end);
            if (pivot < k - 1) {
                start = pivot + 1;
            } else if (pivot > k - 1) {
                end = pivot - 1;
            }
        } while (pivot != k - 1);
        return nums[pivot];
    }

    private int quickSelect(int start, int end) {
        int smallItemId = start;
        for (int i = start; i < end; i++) {
            if (mNums[i] > mNums[end]) {
                if (i != smallItemId) {
                    int temp = mNums[i];
                    mNums[i] = mNums[smallItemId];
                    mNums[smallItemId] = temp;
                }
                smallItemId++;
            }
        }
        int temp = mNums[end];
        mNums[end] = mNums[smallItemId];
        mNums[smallItemId] = temp;
        return smallItemId;
    }
}
