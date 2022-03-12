package com.namanh.linked_list;

/**
 * https://leetcode.com/problems/merge-nodes-in-between-zeros
 * You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end
 * of the linked list will have Node.val == 0. For every two consecutive 0's, merge all the nodes lying in between them
 * into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.
 *
 * S1: Create a new head to return result
 * S2: Calculate sum, set it to 0 node, move previous pointer to sum node
 *    0     0   1 2 3    0    4 5 6     0
 * newHead            sumNode
 *
 * Time: O(n)
 * Space: O(1)
 */
public class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode(0, head);
        ListNode node = newHead.next;
        while (node.next != null) {
            ListNode sumNode = node.next;
            int sum = 0;
            while (sumNode.val != 0) {
                sum += sumNode.val;
                sumNode = sumNode.next;
            }
            sumNode.val = sum;
            node.next = sumNode;
            node = node.next;
        }
        return newHead.next.next;
    }
}
