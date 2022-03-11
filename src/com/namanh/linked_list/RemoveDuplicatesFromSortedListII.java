package com.namanh.linked_list;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
 * from the original list. Return the linked list sorted as well.
 *
 * S1: Create a new head to return
 * S2: Compare next node and next of next node value, if duplicate, move pointer until found different element
 * S3: If there are duplicate elements, ignore them
 * S4: If not, move pointer to next element
 * S5: Return newHead.next
 *
 * Time: O(n)
 * Space: O(1)
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0, head);

        ListNode node = newHead;
        while (node.next != null) {
            ListNode nextNode = node.next;
            boolean isDuplicate = false;
            while (nextNode.next != null && nextNode.val == nextNode.next.val) {
                nextNode = nextNode.next;
                isDuplicate = true;
            }
            if (isDuplicate) {
                node.next = nextNode.next;
            } else {
                node = node.next;
            }
        }
        return newHead.next;
    }
}
