/**
 * MEDIUM
 * 
 * This problem was asked by Jane Street.

cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

Implement car and cdr.

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

PYTHON IMPLEMENTATION:

def car(f):
    def left(a, b):
        return a
    return f(left)

def cdr(f):
    def right(a, b):
        return b
    return f(right)

print(car(cons(3,4)))
print(cdr(cons(3,4)))

https://galaiko.rocks/posts/2018-07-06/
 */
package com.m3rg.daily_coding.problems;

public class Day5 {

    public static void main(String[] args) {
        Day5 obj = new Day5();
        pair p = obj.cons(3, 4);
        int left = obj.car(p);
        int right = obj.cdr(p);
        System.out.println(left);
        System.out.println(right);
    }

    public pair cons(int a, int b) {
        return (method) -> {
            return method.apply(a, b);
        };
    }

    public PairObj getIntPair(int a, int b) {
        return new PairObj(a, b);
    }

    public int car(pair p) {
        PairObj nums = p.apply(this::getIntPair);
        return nums.left;
    }

    public int cdr(pair p) {
        PairObj nums = p.apply(this::getIntPair);
        return nums.right;
    }

    @FunctionalInterface
    public interface cons {
        pair apply(int a, int b);
    }

    @FunctionalInterface
    public interface pair {
        PairObj apply(f method);
    }

    @FunctionalInterface
    public interface f {
        PairObj apply(int a, int b);
    }

    class PairObj {
        int left;
        int right;

        PairObj(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}
