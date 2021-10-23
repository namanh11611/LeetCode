package com.namanh.linked_list;

/**
 * Link: https://leetcode.com/problems/reverse-linked-list
 * Question: Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    /**
     * Method 1: Iterative
     * S1: Store next node
     * S2: Change current linked from nextNode to prevNode
     * S3: Move prev & node
     */
    public ListNode reverseList(ListNode head) {
        ListNode nextNode;
        ListNode prevNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return prevNode;
    }

    /**
     * Method 2: Recursive
     * S1: Create recursive function with 2 params: current and prev node
     * S2: Create linked from current node to prev node
     * S3: Call recursive function
     */
    public ListNode reverseList2(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode node, ListNode prevNode) {
        if (node == null) return prevNode;
        ListNode nextNode = node.next;
        node.next = prevNode;
        return reverseList(nextNode, node);
    }
}
