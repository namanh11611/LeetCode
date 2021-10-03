package com.namanh.linked_list;

/**
 * https://leetcode.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode curNode = head;
        ListNode prev = null;
        while (head.next != null) {
            head = head.next;
            curNode.next = prev;
            prev = curNode;
            curNode = head;
        }
        curNode.next = prev;
        return curNode;
    }
}
