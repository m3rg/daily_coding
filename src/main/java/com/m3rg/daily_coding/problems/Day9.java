/**
 * HARD
 * Array
 * This problem was asked by Airbnb.

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 */
package com.m3rg.daily_coding.problems;

public class Day9 {

    public static void main(String[] args) {
        //int[] nums = { -1, -2, -1, -1, -1, -1, -9 };
        int[] nums = { 1, 2, 4, 7, 2, 3, 8 };
        Day9 obj = new Day9();
        int result = obj.largestSum(nums);
        System.out.println(result);
    }

    public int largestSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int incl = nums[0];
        int excl = Integer.MIN_VALUE;
        int exclNew;
        for (int i = 1; i < nums.length; i++) {
            exclNew = Math.max(incl, excl);
            incl = (i == 1 ? nums[i] : excl + nums[i]);
            excl = exclNew;
        }
        return Math.max(incl, excl);
    }
}
