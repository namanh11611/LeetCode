package com.namanh.heap_priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream
 * Implement the MedianFinder class:
 * - addNum(int num) adds the integer num from the data stream to the data structure.
 * - findMedian() returns the median of all elements so far. Answers within 10^-5 of the actual answer will be accepted.
 */
public class MedianFinder {
    PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> minQueue;

    public MedianFinder() {
        maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        minQueue = new PriorityQueue<>();
    }

    /**
     * First approach: Check size of queue
     */
    public void addNum(int num) {
        if (maxQueue.size() == minQueue.size()) {
            /*
             * When maxQueue.size == minQueue.size: 1 2 3  |  4 5 6
             * Add min queue first, then move top to max queue
             */
            minQueue.offer(num);
            maxQueue.offer(minQueue.poll());
        } else {
            /*
             * When maxQueue.size == minQueue.size + 1: 1 2 3 4  |  5 6 7
             * Add max queue first, then move top to min queue
             */
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
        }
    }

    /**
     * Second approach: Check top value of max queue
     */
    public void addNum2(int num) {
        /*
         * Compare num with maxQueue top before add value into minQueue/maxQueue
         */
        if (maxQueue.isEmpty() || num <= maxQueue.peek()) {
            maxQueue.offer(num);
        } else {
            minQueue.offer(num);
        }

        /*
         * Move element to 2 queue balance together. We keep it in 2 cases:
         * - maxQueue.size == minQueue.size:        1 2 3  |  4 5 6
         * - maxQueue.size == minQueue.size + 1:  1 2 3 4  |  5 6 7
         */
        if (maxQueue.size() < minQueue.size()) {
            maxQueue.offer(minQueue.poll());
        } else if (maxQueue.size() > minQueue.size() + 1) {
            minQueue.offer(maxQueue.poll());
        }
    }

    public double findMedian() {
        if (maxQueue.size() == minQueue.size()) {
            return (maxQueue.peek() + minQueue.peek()) * 0.5;
        } else {
            return maxQueue.peek();
        }
    }
}
