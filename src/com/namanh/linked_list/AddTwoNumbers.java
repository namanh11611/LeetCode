package com.namanh.linked_list;

/**
 * https://leetcode.com/problems/add-two-numbers
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode sum = head;
        int remain = 0;
        while(l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sumtemp = x + y + remain;
            sum.next = new ListNode(sumtemp % 10);
            remain = sumtemp / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            sum = sum.next;
        }
        if (remain > 0) sum.next = new ListNode(remain);
        return head.next;
    }
}
