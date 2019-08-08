package com.m3rg.daily_coding.utils.trie;

import java.util.Map;
import java.util.TreeMap;

public class TrieNode {
    private Map<Character, TrieNode> children;
    private char c;
    private boolean isWord;

    public TrieNode(char c) {
        this.c = c;
        children = new TreeMap<>();// For sorting
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    /**
     * @param isWord the isWord to set
     */
    public void setWord(boolean isWord) {
        this.isWord = isWord;
    }

    public boolean isWord() {
        return isWord;
    }

    public char getChar() {
        return c;
    }

    public void setChar(char c) {
        this.c = c;
    }
}
