/**
 * MEDIUM
 * Job Scheduler
 * This problem was asked by Apple.

Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
 */
package com.m3rg.daily_coding.problems;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Day10 {

    private static ScheduledExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newSingleThreadScheduledExecutor();

        Runnable f = () -> {
            System.out.println("Hello...");
        };
        int n = 1000;
        Day10 obj = new Day10();
        obj.scheduler(f, n);

        executor.shutdown();
        executor = null;
    }

    public ScheduledFuture<?> scheduler(Runnable f, int n) {
        System.out.println("started");
        return executor.schedule(f, n, TimeUnit.MILLISECONDS);
    }
}
