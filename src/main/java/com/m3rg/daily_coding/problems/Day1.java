/**
 * This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
 */
package com.m3rg.daily_coding.problems;

import java.util.HashSet;
import java.util.Set;

public class Day1 {

    public static void main(String[] args) {
        Day1 obj = new Day1();
        int[] nums = new int[] { 10, 15, 3, 8 };
        int k = 17;
        boolean result = obj.check(nums, k);
        System.out.println(result);
    }

    public boolean check(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(k - num);
        }
        return false;
    }
}
