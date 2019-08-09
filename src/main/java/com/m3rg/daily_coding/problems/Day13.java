/**
 * HARD
 * Two Pointer
 * This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
package com.m3rg.daily_coding.problems;

import java.util.HashMap;
import java.util.Map;

public class Day13 {

    public static void main(String[] args) {
        String s = "xaaxxyyzs";
        int k = 3;
        Day13 obj = new Day13();
        int result = obj.longestDistinctSubStrMap(s, k);
        System.out.println(result);
    }

    // Solution 1, with array of english letters
    public int longestDistinctSubStr(String s, int k) {
        int[] arr = new int[26];
        int distinct = 0;
        int len = 0;
        int j = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (distinct == k && arr[index] == 0) {
                int beginIndex = j;
                while (true) {
                    int leftIndex = s.charAt(j) - 'a';
                    arr[leftIndex]--;
                    if (arr[leftIndex] == 0) {
                        distinct--;
                        j++;
                        break;
                    }
                    j++;
                }
                len -= j - beginIndex;
            }
            len++;
            if (arr[index] == 0) {
                distinct++;
            }
            arr[index]++;
            if (distinct <= k) {
                max = Math.max(max, len);
            }
        }
        return max;
    }

    // Solution 2, with hash map
    public int longestDistinctSubStrMap(String s, int k) {
        Map<Character, Integer> m = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            m.put(c, m.getOrDefault(c, 0) + 1);

            if (m.size() > k) {
                max = Math.max(max, i - start);
                while (m.size() > 2) {
                    char t = s.charAt(start);
                    int count = m.get(t);
                    if (count > 1) {
                        m.put(t, count - 1);
                    } else {
                        m.remove(t);
                    }
                    start++;
                }
            }
        }
        max = Math.max(max, s.length() - start);
        return max;
    }
}
