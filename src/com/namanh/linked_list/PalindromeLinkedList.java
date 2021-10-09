package com.namanh.linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-linked-list
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> val = new ArrayList<>();
        while (head != null) {
            val.add(head.val);
            head = head.next;
        }
        int front = 0;
        int rear = val.size() - 1;
        while (front < rear) {
            if (val.get(front) != val.get(rear)) return false;
            front++;
            rear--;
        }
        return true;
    }
}
