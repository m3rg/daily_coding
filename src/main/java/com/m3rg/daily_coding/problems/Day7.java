/**
 * MEDIUM
 * Dynamic Programming
 * This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

https://www.youtube.com/watch?v=qli-JCrSwuk&t=884s
 */
package com.m3rg.daily_coding.problems;

public class Day7 {

    public static void main(String[] args) {
        String msg = "1111111";
        Day7 obj = new Day7();
        int result = obj.decodeWays(msg);
        System.out.println(result);
    }

    public int decodeWays(String msg) {
        int[] memo = new int[msg.length() + 1];
        return helper(msg, msg.length(), memo);
    }

    public int helper(String msg, int k, int[] memo) {
        if (k == 0) {
            return 1;
        }
        int index = msg.length() - k;
        /*if (msg.charAt(index) == '0') {
            return 0;
        }*/
        if(memo[k] != 0) {
            return memo[k];
        }
        int result = helper(msg, k - 1, memo);
        if (k >= 2 && Integer.parseInt(msg.substring(index, index + 2)) <= 26) {
            result += helper(msg, k - 2, memo);
        }
        memo[k] = result;
        return result;
    }
}
