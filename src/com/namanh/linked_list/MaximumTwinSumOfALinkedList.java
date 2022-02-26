package com.namanh.linked_list;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list
 * The twin sum is defined as the sum of a node and its twin.
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 *
 * S1: Find the middle node by 2 pointers
 * S2: Use Stack to store the first half of linked list
 * S3: Iterate the second half and pop from Stack to calculate sum
 *
 * Time: O(n)
 * Space: O(n)
 */
public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        int maxSum = 0;
        while (slow != null) {
            maxSum = Math.max(maxSum, slow.val + stack.pop());
            slow = slow.next;
        }
        return maxSum;
    }
}
