package LeetCode75.HashMapSet;

// Unique Number of Occurrences
public class leetcode_1207 {
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> HM = new HashMap<>();

            for (int a : arr) {
                HM.put(a, HM.getOrDefault(a, 0) + 1);
            }

            Set<Integer> set = new HashSet<>(HM.values());

            return set.size() == HM.size();
        }
    }
}
