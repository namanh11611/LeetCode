package com.namanh.linked_list;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes
 * of the first two lists.
 *
 * S1: Create head node to store head
 * S2: Compare 2 linked list and get smaller value, assign for node.next
 * S3: Assign remainder for node.next
 *
 * Time: O(n)
 * Space: O(n)
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode head = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
