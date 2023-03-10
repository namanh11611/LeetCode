package com.namanh.linked_list

import kotlin.random.Random

/**
 * https://leetcode.com/problems/linked-list-random-node
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same
 * probability of being chosen.
 */
class LinkedListRandomNode(val head: ListNode?) {

    var size = 0

    init {
        var node = head
        while (node != null) {
            node = node.next
            size++
        }
    }

    fun getRandom(): Int {
        var ran = Random.nextInt(0, size)
        var node = head
        while (ran > 0) {
            node = node?.next
            ran--
        }
        return node?.`val` ?: 0
    }

}