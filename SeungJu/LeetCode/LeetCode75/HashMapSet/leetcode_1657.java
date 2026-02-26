package LeetCode75.HashMapSet;

// Determine if Two Strings Are Close
public class leetcode_1657 {
    class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) return false;

            Map<Character, Integer> map1 = new HashMap<>();
            for (char c : word1.toCharArray()) {
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            }

            Map<Character, Integer> map2 = new HashMap<>();
            for (char c : word2.toCharArray()) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }

            if (!map1.keySet().equals(map2.keySet())) {
                return false;
            }

            List<Integer> freq1 = new ArrayList<>(map1.values());
            List<Integer> freq2 = new ArrayList<>(map2.values());

            Collections.sort(freq1);
            Collections.sort(freq2);

            return freq1.equals(freq2);
        }
    }
}
