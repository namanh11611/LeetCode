package com.namanh.dfs;

import java.util.List;

/**
 * Link: https://leetcode.com/problems/keys-and-rooms
 * Question: Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 * S1: Use DFS to visit all rooms if enable
 * S2: Return true when number visited equals number rooms
 */
public class KeysAndRooms {
    int count = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] visited = new int[n];
        dfs(rooms, 0, visited);
        return count == n;
    }

    private void dfs(List<List<Integer>> rooms, int roomId, int[] visited) {
        visited[roomId] = 1;
        count++;
        List<Integer> keys = rooms.get(roomId);
        for (int key : keys) {
            if (visited[key] == 0) {
                dfs(rooms, key, visited);
            }
        }
    }
}
