package com.m3rg.daily_coding.utils.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {

    private TrieNode root;
    private int wordCount;

    public Trie() {
        root = new TrieNode('0');
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode(c));
        }
        current.setWord(true);
    }

    public boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.getChildren().get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isWord();
    }

    public List<String> autocomplete(String word, int max) {
        List<String> result = new ArrayList<>();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.getChildren().get(c);
            if (node == null) {
                return result;
            }
            current = node;
        }
        wordCount = 0;
        StringBuilder sb = new StringBuilder(word);
        collectWords(result, sb, current, max);
        return result;
    }

    private void collectWords(List<String> result, StringBuilder sb, TrieNode node, int max) {
        if (node == null) {
            return;
        }
        if (wordCount == max) {
            return;
        }
        if (node.isWord()) {
            wordCount++;
            result.add(sb.toString());
        }
        for (Map.Entry<Character, TrieNode> entrySet : node.getChildren().entrySet()) {
            StringBuilder nsb = new StringBuilder(sb.toString());
            nsb.append(entrySet.getKey());
            collectWords(result, nsb, entrySet.getValue(), max);
        }
    }
}
