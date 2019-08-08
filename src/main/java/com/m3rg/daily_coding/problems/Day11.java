/**
 * MEDIUM
 * Trie
 * This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
 */
package com.m3rg.daily_coding.problems;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.m3rg.daily_coding.utils.trie.Trie;

public class Day11 {

    public static void main(String[] args) {
        Day11 obj = new Day11();
        Set<String> words = new HashSet<>();
        Collections.addAll(words, "apple", "pear", "cactus", "and", "abby", "ask", "aspire", "aspirin", "aspect",
                "aspiration", "rabbit", "dog", "cat", "orange", "pink", "yellow");
        List<String> result = obj.autocomplete("as", words);
        System.out.println(result);
    }

    public List<String> autocomplete(String s, Set<String> words) {
        Trie t = new Trie();
        for (String word : words) {
            t.insert(word);
        }
        return t.autocomplete(s, 3);
    }
}
