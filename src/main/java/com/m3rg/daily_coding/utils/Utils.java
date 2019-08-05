package com.m3rg.daily_coding.utils;

import java.util.Arrays;
import java.util.StringJoiner;

public class Utils {

    public static void printArray(int[] nums) {
        StringJoiner sj = new StringJoiner(", ");
        Arrays.stream(nums).forEach(num -> sj.add(String.valueOf(num)));
        System.out.println(sj.toString());
    }
}
