/**
 * HARD
 * 
 * This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

https://www.geeksforgeeks.org/a-product-array-puzzle/

 */
package com.m3rg.daily_coding.problems;

import com.m3rg.daily_coding.utils.Utils;

public class Day2 {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 4, 5, 6, -1 };
        Day2 obj = new Day2();
        int[] result = obj.solution2(nums);
        Utils.printArray(result);
    }

    /**
     * Time Complexity: O(n) Space Complexity: O(n) Auxiliary Space: O(n)
     */
    public int[] solution1(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] p = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            p[i] = left[i] * right[i];
        }
        return p;
    }

    /**
     * Time Complexity: O(n) Space Complexity: O(n) Auxiliary Space: O(1)
     */
    public int[] solution2(int[] nums) {
        int[] p = new int[nums.length];
        int temp = 1;
        // Keep left side of product of nums in temp;
        for (int i = 0; i < nums.length; i++) {
            p[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        // Add right side of the products to the product array
        for (int i = nums.length - 1; i >= 0; i--) {
            p[i] *= temp;
            temp *= nums[i];
        }
        return p;
    }

    /**
     * !!!! Will not work for zero or negative values
     */
    public int[] solution3(int[] nums) {
        // epsilon value to maintain precision
        final double EPS = 1e-9;
        int p[] = new int[nums.length];
        // to hold sum of all values
        double sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += Math.log10(nums[i]);

        // output product for each index
        // anti log to find original product value
        for (int i = 0; i < nums.length; i++)
            p[i] = (int) (EPS + Math.pow(10.00, sum - Math.log10(nums[i])));
        // System.out.print((int) (EPS + Math.pow(10.00, sum - Math.log10(nums[i]))) +
        // "");
        return p;
    }
}
