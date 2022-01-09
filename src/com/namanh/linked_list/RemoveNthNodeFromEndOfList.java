package com.namanh.linked_list;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * S1: Create new head before current head
 * S2: Move prev and end to the end of linked list
 * S3: Remove node
 * S4: Return newHead.next
 *
 * Time: O(n)
 * Space: O(1)
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode newHead = prev;

        ListNode end = head;
        while (end != null) {
            end = end.next;
            if (n > 0) {
                n--;
            } else {
                prev = prev.next;
            }
        }
        prev.next = prev.next.next;
        return newHead.next;
    }
}
