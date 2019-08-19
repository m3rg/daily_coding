/**
 * MEDIUM
 * Monte Carlo Estimation
 * This problem was asked by Google.

The area of a circle is defined as r^2. Estimate \pi to 3 decimal places using a Monte Carlo method.

Hint: The basic equation of a circle is x^2 + y^2 = r^2.

https://www.geeksforgeeks.org/estimating-value-pi-using-monte-carlo/
 */
package com.m3rg.daily_coding.problems;

public class Day14 {

    public static void main(String[] args) {
        Day14 obj = new Day14();
        double result = obj.estimatePi(100000);
        System.out.printf("Final Estimation of Pi: %.3f\n", result);
    }

    public double estimatePi(int interval) {
        double randX;
        double randY;
        double pi = 0;
        int circlePoints = 0;
        int squarePoints = 0;
        for (int i = 0; i < interval; i++) {
            randX = Math.random();
            randY = Math.random();
            if ((randX * randX) + (randY * randY) <= 1) {
                circlePoints++;
            }
            squarePoints++;
            pi = (double) (4 * circlePoints) / squarePoints;
            System.out.printf("Circle: %d Square: %d X: %f Y: %f Pi: %f\n", circlePoints, squarePoints, randX, randY,
                    pi);
        }
        return pi;
    }
}
