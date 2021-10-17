package com.namanh.queue;

/**
 * Link: https://leetcode.com/problems/design-circular-queue
 * Question: Implement Circular Queue
 */
class MyCircularQueue {
    int[] queue;
    int head;
    int tail;
    int size;
    int capacity;

    public MyCircularQueue(int k) {
        queue = new int[k];
        head = 0;
        tail = -1;
        size = 0;
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        tail = tail == capacity -1 ? 0 : tail + 1;
        queue[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = head == capacity - 1 ? 0 : head + 1;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
