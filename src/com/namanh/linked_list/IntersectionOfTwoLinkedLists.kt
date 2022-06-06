package com.namanh.linked_list

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the
 * two linked lists have no intersection at all, return null.
 *
 * A:        4 - 1
 *                 \
 *                  8 - 4 - 5
 *                 /
 * B:     5 - 6 - 1
 *
 * S1: Iterate both A and B
 * S2: If pointer A go to the tail of list A, go back to the head B
 * S3: If pointer B go to the tail of list B, go back to the head A -> pointer A already n - m steps
 * S4: Both 2 pointers go to intersect or end of 2 list
 *
 * Time: O(m + n)
 * Space: O(1)
 */
class IntersectionOfTwoLinkedLists {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var nodeA = headA
        var nodeB = headB
        while (nodeA != nodeB) {
            nodeA = if (nodeA != null) nodeA.next else headB
            nodeB = if (nodeB != null) nodeB.next else headA
        }
        return nodeA
    }
}