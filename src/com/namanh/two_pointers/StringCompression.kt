package com.namanh.two_pointers

/**
 * https://leetcode.com/problems/string-compression
 * Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * - If the group's length is 1, append the character to s.
 * - Otherwise, append the character followed by the group's length.
 * After you are done modifying the input array, return the new length of the array.
 *
 * S1: Compare 2 adjacent elements, change counter when they are different
 * S2: Keep index at the first of group same elements
 *
 * Time: O(n)
 * Space: O(1)
 */
object StringCompression {
    fun compress(chars: CharArray): Int {
        var prev = chars[0]
        var count = 1
        var index = 0
        for (i in 1 until chars.size) {
            if (chars[i] == prev) {
                count++
            } else {
                chars[index] = prev
                index += changeChar(chars, count, index + 1)
                count = 1
                prev = chars[i]
            }
        }
        chars[index] = prev
        index += changeChar(chars, count, index + 1)
        return index
    }

    private fun changeChar(chars: CharArray, count: Int, index: Int): Int {
        if (count == 1) return 1
        val countChar = count.toString().toCharArray()
        for (i in countChar.indices) {
            chars[index + i] = countChar[i]
        }
        return countChar.size + 1
    }
}