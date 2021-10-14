package com.namanh.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/sliding-window-maximum
 * S1: Use a deque (size = k) to store index of potential number
 * S2: Check head of deque, if index out of range i-k => remove
 * S3: Check tail of deque, if number < current number => remove
 * S4: Push current number to deque
 * S5: Add head of deque into result array
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[n-k+1];
        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && queue.peek() == i - k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);

            if (i >= k-1) {
                result[i-k+1] = nums[queue.peek()];
            }
        }
        return result;
    }
}
