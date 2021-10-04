package com.namanh.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet();
        int sum = 0;
        int digit;
        while (sum != 1) {
            sum = 0;
            while (n != 0) {
                digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            if (sumSet.contains(sum)) return false;
            sumSet.add(sum);
            n = sum;
        }
        return true;
    }
}
