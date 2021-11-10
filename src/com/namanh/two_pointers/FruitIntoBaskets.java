package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/fruit-into-baskets
 * Return length of the longest sub array that contains at most 2 distinct elements.
 *
 *             sumTwoBaskets  second
 *          -----------------/
 *    1 1 1 2 2 2 3 3 2 2 2 2 ? -> fruit
 *                 /  -------
 *             first  lastBasket
 *
 * S1: Iterate fruits array, compare current fruit with first, second pointer
 * S2: Update sumTwoBaskets and lastBasket
 *
 * Time: O(n)
 * Space: O(1)
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int sumTwoBaskets = 0;
        int lastBasket = 0;
        int first = -1;
        int second = -1;
        int max = 0;
        for (int fruit : fruits) {
            if (fruit == second) {
                sumTwoBaskets++;
                lastBasket++;
            } else {
                if (fruit == first) {
                    sumTwoBaskets++;
                } else {
                    sumTwoBaskets = lastBasket + 1;
                }
                first = second;
                second = fruit;
                lastBasket = 1;
            }
            max = Math.max(max, sumTwoBaskets);
        }
        return max;
    }
}
