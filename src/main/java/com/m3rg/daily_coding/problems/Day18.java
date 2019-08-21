/**
 * HARD
 * Queue
 * Google
 * This problem was asked by Google.

Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)

Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 * 
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 */
package com.m3rg.daily_coding.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Day18 {

    public static void main(String[] args) {
        Day18 obj = new Day18();
        obj.maxValuesSubArray(new int[] { 10, 5, 2, 7, 8, 7 }, 3);
    }

    public void maxValuesSubArray(int[] arr, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int i;
        for (i = 0; i < k; i++) {
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        for (; i < arr.length; i++) {
            System.out.println(arr[q.peek()]);
            while (!q.isEmpty() && q.peek() <= i - k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        System.out.println(arr[q.peek()]);
    }
}
