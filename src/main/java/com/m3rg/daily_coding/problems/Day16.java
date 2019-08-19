/**
 * EASY
 * Stack
 * Twitter
You run an e-commerce website and want to record the last N order ids in a log.
Implement a data structure to accomplish this, with the following API:
    -> record(order_id): adds the order_id to the log  
    -> get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
You should be as efficient with time and space as possible.
 */
package com.m3rg.daily_coding.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Day16 {

    Deque<String> logStack = new ArrayDeque<>();

    public static void main(String[] args) {
        Day16 obj = new Day16();
        obj.record("A1");
        obj.record("A2");
        obj.record("A3");
        obj.record("A4");
        obj.record("A5");
        obj.record("A6");

        obj.printLast(1);
        obj.printLast(2);
        obj.printLast(3);
        obj.printLast(4);
        obj.printLast(5);
        obj.printLast(6);
        obj.printLast(0);
        obj.printLast(-1);
        obj.printLast(8);
    }

    public void record(String orderId) {
        logStack.push(orderId);
    }

    public String getLast(int i) {
        if (i < 1 || i > logStack.size()) {
            throw new NoSuchElementException(String.format("Element at index %d not found.", i));
        }
        Iterator<String> it = logStack.iterator();
        while (it.hasNext() && i > 1) {
            it.next();
            i--;
        }
        return it.next();
    }

    public void printLast(int i) {
        try {
            System.out.println(getLast(i));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
