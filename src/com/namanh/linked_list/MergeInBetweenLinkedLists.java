package com.namanh.linked_list;

/**
 * https://leetcode.com/problems/merge-in-between-linked-lists
 * You are given two linked lists: list1 and list2 of sizes n and m respectively.
 * Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 *
 * S1: Reduce a, change b value
 * S2: Iterate list1 to (a-1)th node, mark it by new ListNode first
 * S3: Iterate list1 to (b+1)th node, set first.next = list2
 * S4: Iterate to end of list2, set next to (b+1)th node of list1
 *
 * Time: O(m + n)
 * Space: O(1)
 */
public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;

        b = b - a + 2;
        a--;
        while (a > 0) {
            list1 = list1.next;
            a--;
        }
        ListNode first = list1;

        while (b > 0) {
            list1 = list1.next;
            b--;
        }
        first.next = list2;

        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = list1;
        return head;
    }
}
