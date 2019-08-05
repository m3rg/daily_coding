/**
 * HARD
 * 
 * This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

https://stackoverflow.com/questions/51346136/given-an-array-of-integers-find-the-first-missing-positive-integer-in-linear-ti
https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
 */
package com.m3rg.daily_coding.problems;

public class Day4 {

    public static void main(String[] args) {
        int[] nums = { -1, 2, 3, 1, -45 };
        Day4 obj = new Day4();
        int result = obj.findMissingPositive(nums);
        System.out.println(result);
    }

    public int findMissingPositive(int[] arr) {
        if (arr.length == 0) {
            return 1;
        }
        for (int i = 0; i < arr.length;) {
            // We have to take care of special case when we have duplicates
            // For Example with Input : 4 4 -1 4
            if (arr[i] - 1 < arr.length && arr[i] > 0 && arr[i] != i + 1 && arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }

        // Now let's traverse and find the answer
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return arr[arr.length - 1] + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
