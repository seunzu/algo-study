package LeetCode75.Trie;

// Search Suggestions System
public class leetcode_1268 {
    class Solution {
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            List<String> suggestions = new ArrayList<>();
        }

        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int idx = c - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }

                node = node.children[idx];

                if (node.suggestions.size() < 3) {
                    node.suggestions.add(word);
                }
            }
        }

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);

            for (String p : products) insert(p);

            List<List<String>> result = new ArrayList<>();
            TrieNode node = root;

            for (char c : searchWord.toCharArray()) {
                if (node != null) {
                    node = node.children[c - 'a'];
                }

                if (node == null) result.add(new ArrayList<>());
                else result.add(node.suggestions);
            }

            return result;
        }
    }
}
