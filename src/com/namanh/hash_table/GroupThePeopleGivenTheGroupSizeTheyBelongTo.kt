package com.namanh.hash_table

/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to
 * You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in.
 * Return a list of groups such that each person i is in a group of size groupSizes[i].
 *
 * S1: Create a map, key is groupSize, value is list of person index
 * S2: When list size is equals group size, add it to result
 *
 * Time: O(n)
 * Space: O(n)
 */
class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val map = HashMap<Int, MutableList<Int>>()
        for ((index, size) in groupSizes.withIndex()) {
            val curList = map.getOrDefault(size, mutableListOf())
            curList.add(index)
            if (curList.size == size) {
                result.add(curList)
                map[size] = mutableListOf()
            } else {
                map[size] = curList
            }
        }
        return result
    }
}