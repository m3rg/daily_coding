/**
 * HARD
 * Stack
 * Google
 * This problem was asked by Google.

Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext

The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext

The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

https://www.programcreek.com/2014/08/leetcode-longest-absolute-file-path-java/
 */
package com.m3rg.daily_coding.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Day17 {

    public static void main(String[] args) {
        Day17 obj = new Day17();
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int result = obj.longestPath(s);
        System.out.println(result);

        System.out.println(obj.longestPath("dir\ndir2\n\tsub2\n\t\ts.txt\nveryverylongtext.txt"));
    }

    public int longestPath(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        String[] lines = s.split("\n");
        int max = 0;
        for(String line: lines) {
            int dept = countSubstring(line, "\t");
            int len = line.length() - dept;
            while(dept < stack.size() - 1) {
                stack.pop();
            }
            if(line.contains(".")) {
                max = Math.max(max, len  + stack.peek());
            } else {
                stack.push(stack.peek() + len + 1);
            }
        }
        return max;
    }

    private int countSubstring(String s, String sub) {
        int count = 0;
        if (!s.isEmpty() && !sub.isEmpty()) {
            for (int i = 0; (i = s.indexOf(sub, i)) != -1; i += sub.length()) {
                count++;
            }
        }
        return count;
    }
}
