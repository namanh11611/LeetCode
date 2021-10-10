package com.namanh.number;

/**
 * https://leetcode.com/problems/palindrome-number
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int[] number = new int[12];
        int size = 0;
        while (x > 0) {
            number[size++] = x % 10;
            x = x / 10;
        }
        int index = 0;
        while (index < size / 2) {
            if (number[size - index - 1] != number[index++]) {
                return false;
            }
        }
        return true;
    }
}
