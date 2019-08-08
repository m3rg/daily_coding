/**
 * HARD
 * Dynammic Programming
 * This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

    1, 1, 1, 1
    2, 1, 1
    1, 2, 1
    1, 1, 2
    2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
package com.m3rg.daily_coding.problems;

public class Day12 {

    public static void main(String[] args) {
        int n = 12;
        Day12 obj = new Day12();
        int result = obj.uniqueWaysIterative2(n);
        System.out.println(result);
    }

    /**
     * Solution 1, Iterative
     * 
     * @param n
     * @return
     */
    public int uniqueWaysIterative(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    /**
     * Solution 2, Iterative, Space Efficient
     * 
     * @param n
     * @return
     */
    public int uniqueWaysIterative2(int n) {
        if (n < 2) {
            return n;
        }
        int sum = 0;
        int pre1 = 1;
        int pre2 = 0;
        for (int i = 2; i <= n; i++) {
            sum = pre1 + pre2;
            pre2 = pre1;
            pre1 = sum;
        }
        return sum;
    }

    /**
     * Solution 3, Recursive
     * 
     * @param n
     * @return
     */
    public int uniqueWaysRecursive(int n) {
        int[] memo = new int[n + 1];
        return uniqueWaysRecursive(n, memo);
    }

    public int uniqueWaysRecursive(int n, int[] memo) {
        if (n <= 1) {
            memo[n] = n;
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = uniqueWaysRecursive(n - 1, memo) + uniqueWaysRecursive(n - 2, memo);
        return memo[n];
    }

}
