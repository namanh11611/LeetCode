package com.namanh.heap_priority_queue;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted
 * order, not the kth distinct element.
 *
 * S1: If queue size < capacity, add element normally
 * S2: If queue full, only add element > queue peek
 * S3: Return queue peek after add element
 *
 * Time: O(n * log(n) + m * log(k))
 *       - m is number query add element
 *       - k is capacity of queue
 * Space: O(n)
 */
public class KthLargest {
    PriorityQueue<Integer> queue;
    int capacity;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < capacity) {
            queue.offer(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
