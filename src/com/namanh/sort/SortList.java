package com.namanh.sort;

import com.namanh.linked_list.ListNode;

/**
 * https://leetcode.com/problems/sort-list
 * Step 1: Get middle
 * Step 2: Break middle
 * Step 3: Return 2 new head to sort
 * Step 4: Merge 2 sub list
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode part1 = sortList(head);
        ListNode part2 = sortList(mid);
        return mergeSort(part1, part2);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    private ListNode mergeSort(ListNode part1, ListNode part2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (part1 != null && part2 != null) {
            if (part1.val < part2.val) {
                tail.next = part1;
                part1 = part1.next;
            } else {
                tail.next = part2;
                part2 = part2.next;
            }
            tail = tail.next;
        }

        if (part1 != null) {
            tail.next = part1;
        }

        if (part2 != null) {
            tail.next = part2;
        }

        // Ignore first node
        return head.next;
    }
}
