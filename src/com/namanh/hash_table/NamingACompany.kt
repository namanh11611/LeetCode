package com.namanh.hash_table

/**
 * https://leetcode.com/problems/naming-a-company
 * You are given an array of strings ideas that represents a list of names to be used in the process of naming a
 * company. The process of naming a company is as follows:
 * - Choose 2 distinct names from ideas, call them ideaA and ideaB.
 * - Swap the first letters of ideaA and ideaB with each other.
 * If both of the new names are not found in the original ideas, then the name ideaA ideaB (the concatenation of ideaA
 * and ideaB, separated by a space) is a valid company name. Otherwise, it is not a valid name.
 * Return the number of distinct valid names for the company.
 *
 * S1: We use an array with size = 26 to store suffix of all ideas
 * S2: Compare 2 sets, ignore common suffix, calculate distinct suffix
 *
 * Time: O(n * m) with m is average length of a word
 * Space: O(n * m)
 */
object NamingACompany {
    fun distinctNames(ideas: Array<String>): Long {
        val map = Array(26) {
            mutableSetOf<String>()
        }

        for (idea in ideas) {
            map[idea[0] - 'a'].add(idea.substring(1))
        }

        var result = 0L
        for (i in 0..25) {
            for (j in i + 1..25) {
                val common = map[i].count {
                    map[j].contains(it)
                }
                result += 2 * (map[i].size - common) * (map[j].size - common)
            }
        }
        return result
    }
}