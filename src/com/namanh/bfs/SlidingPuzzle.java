package com.namanh.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/sliding-puzzle
 * Given the puzzle board, return the least number of moves required so that the state of the board is solved.
 * If it is impossible for the state of the board to be solved, return -1.
 *
 * S1: Create list to describe next empty index when change state of the board
 * S2: Use BFS to visit all state, use string to describe the current state
 * S3: Swap empty position and adjacent position to create next state, use Set to check exist state
 * S4: Return when state equals "123450"
 *
 * Space: O(n)
 * Time: Maximum step is factorial 6 (6! = 120)
 */
public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        List<int[]> swap = new ArrayList<>();
        swap.add(new int[]{1, 3});
        swap.add(new int[]{0, 2, 4});
        swap.add(new int[]{1, 5});
        swap.add(new int[]{0, 4});
        swap.add(new int[]{1, 3, 5});
        swap.add(new int[]{2, 4});

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        StringBuilder start = new StringBuilder();
        int step = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start.append(board[i][j]);
            }
        }
        queue.offer(start.toString());
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String current = queue.poll();
                if (current.equals("123450")) return step;

                if (!set.contains(current)) {
                    set.add(current);
                    int index0 = current.indexOf("0");
                    int[] swapList = swap.get(index0);
                    for (int ind : swapList) {
                        queue.offer(swapChar(current, index0, ind));
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String swapChar(String origin, int id0, int id1) {
        StringBuilder builder = new StringBuilder(origin);
        builder.setCharAt(id0, origin.charAt(id1));
        builder.setCharAt(id1, '0');
        return builder.toString();
    }
}
