package com.namanh.linked_list;

/**
 * https://leetcode.com/problems/insertion-sort-list
 * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
 *
 * S1: Create a new head to store result
 * S2: Each step, find the last element less than head
 * S3: Create new node has value equal head value and insert into new linked list
 * S4: Move head to next element
 * S5: Return new head
 *
 * Time: O(n^2)
 * Space: O(n)
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode();
        while (head != null) {
            ListNode cur = newHead;
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            ListNode newNode = new ListNode(head.val);
            newNode.next = cur.next;
            cur.next = newNode;
            head = head.next;
        }
        return newHead.next;
    }
}
