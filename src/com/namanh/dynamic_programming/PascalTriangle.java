package com.namanh.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int size = result.size();
            if (size > 0) {
                List<Integer> prev = result.get(size - 1);
                for (int i = 1; i < row; i++) {
                    list.add(prev.get(i-1) + prev.get(i));
                }
                list.add(1);
            }
            result.add(list);
        }
        return result;
    }
}
