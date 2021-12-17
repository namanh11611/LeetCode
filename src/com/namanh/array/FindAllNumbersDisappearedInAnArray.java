package com.namanh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the
 * range [1, n] that do not appear in nums.
 *
 * S1: Sort array
 * S2: If nums[0] > 1, add all value less than nums[0]
 * S3: If nums[n-1] < n, add all value greater than nums[n-1]
 * S4: Iterate array and add remain value
 *
 * Time: O(n * log(n))
 * Space: O(1) exclude return list
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 1) {
            for (int k = 1; k < nums[0]; k++) {
                result.add(k);
            }
        }

        if (nums[n-1] < n) {
            for (int k = nums[n-1] + 1; k <= n; k++) {
                result.add(k);
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1] + 1) {
                for (int k = nums[i-1] + 1; k < nums[i]; k++) {
                    result.add(k);
                }
            }
        }

        return result;
    }
}
