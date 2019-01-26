package Trees;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class TrieNode {
        Map<Character, TrieNode> childrenList;
        boolean isEndOfWord;

        public TrieNode() {
            childrenList = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /* Insert: Iterative Approach */
    public void iterativeInsert(String input) {
        TrieNode curr = root;
        for(int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            TrieNode cNode = curr.childrenList.get(currentChar);
            if(cNode == null) {
                // not in the Trie
                cNode = new TrieNode();
                curr.childrenList.put(currentChar, cNode);
            }

            curr = cNode;
        }
        curr.isEndOfWord = true;
    }

    /* Search: Iterative Approach */
    public boolean iterativeSeach(String input) {
        TrieNode curr = root;
        for(int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if(curr.childrenList.containsKey(currentChar)) {
                TrieNode cNode = curr.childrenList.get(currentChar);
                curr = cNode;
            } else {
                return false;
            }
        }

        return curr.isEndOfWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.iterativeInsert("Hello");
        trie.iterativeInsert("from");
        trie.iterativeInsert("the");
        trie.iterativeInsert("other");
        trie.iterativeInsert("side");
        trie.iterativeInsert("sing it");

        System.out.println(trie.iterativeSeach("Hello"));
        System.out.println(trie.iterativeSeach("form")); // false
        System.out.println(trie.iterativeSeach("the"));
        System.out.println(trie.iterativeSeach("other"));
        System.out.println(trie.iterativeSeach("side"));
        System.out.println(trie.iterativeSeach("write it")); // false
    }
}
