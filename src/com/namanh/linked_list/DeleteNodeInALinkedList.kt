package com.namanh.linked_list

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list
 */
object DeleteNodeInALinkedList {
    fun deleteNode(node: ListNode?) {
        node?.`val` = node?.next?.`val`
        node?.next = node?.next?.next
    }
}
