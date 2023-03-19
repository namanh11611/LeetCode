package com.namanh.trie

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * Implement the WordDictionary class:
 * - WordDictionary() Initializes the object.
 * - void addWord(word) Adds word to the data structure, it can be matched later.
 * - bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 * word may contain dots '.' where dots can be matched with any letter.
 *
 * S1: Use DFS to search
 */
class WordDictionary() {
    private var head: Node = Node()

    class Node {
        var children = Array<Node?>(26) { null }
        var isEnd = false
    }

    fun addWord(word: String) {
        var cur = head
        for (c in word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = Node()
            }
            cur.children[c - 'a']?.let {
                cur = it
            }
        }
        cur.isEnd = true
    }

    fun search(word: String): Boolean {
        return dfs(head, word, 0)
    }

    fun dfs(node: Node, word: String, index: Int): Boolean {
        if (index == word.length) {
            return node.isEnd
        }
        if (word[index] == '.') {
            var result = false
            for (childNode in node.children) {
                childNode?.let {
                    result = result or dfs(it, word, index + 1)
                }
            }
            return result
        }
        node.children[word[index] - 'a']?.let {
            return dfs(it, word, index + 1)
        } ?: return false
    }
}