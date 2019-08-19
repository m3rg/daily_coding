/**
 * MEDIUM
 * Random nunmbers
 * This problem was asked by Facebook.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.

https://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/
 */
package com.m3rg.daily_coding.problems;

import java.util.Random;

public class Day15 {

    private int res = 0;
    private int count = 0;

    public static void main(String[] args) {
        Day15 obj = new Day15();
        int stream[] = { 1, 3, 6, 7, 9, 12, 18 };
        for (int i = 0; i < stream.length; i++) {
            int result = obj.selectRandom(stream[i]);
            System.out.printf("Random number from first %d numbers is %d\n", i + 1, result);
        }
    }

    public int selectRandom(int x) {
        count++;
        if (count == 1) {
            res = x;
        } else {
            Random r = new Random();
            int i = r.nextInt(count);
            if (i == count - 1) {
                res = x;
            }
        }
        return res;
    }
}
