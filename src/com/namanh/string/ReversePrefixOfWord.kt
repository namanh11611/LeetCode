package com.namanh.string

/**
 * https://leetcode.com/problems/reverse-prefix-of-word
 */
object ReversePrefixOfWord {
    fun reversePrefix(word: String, ch: Char): String {
        for (i in word.indices) {
            if (word[i] == ch) {
                return word.substring(0, i + 1).reversed() + word.substring(i + 1)
            }
        }
        return word
    }
}
