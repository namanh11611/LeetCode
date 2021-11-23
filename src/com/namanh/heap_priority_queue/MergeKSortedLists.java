package com.namanh.heap_priority_queue;

import com.namanh.linked_list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * S1: Create priority queue and push all linked lists into queue
 * S2: Get head of queue and push into linked list result until queue is empty
 *
 * Time: O(n * log(k)) with k is number of linked list
 * Space: O(n + k)
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode node = head;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            node.next = cur;
            node = node.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return head.next;
    }
}
