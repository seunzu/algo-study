package LeetCode75.HashMapSet;

// Find the Difference of Two Arrays
public class leetcode_2215 {
    class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for (int n : nums1) set1.add(n);
            for (int n : nums2) set2.add(n);

            List<Integer> diff1 = new ArrayList<>();
            List<Integer> diff2 = new ArrayList<>();

            for (int s : set1) {
                if (!set2.contains(s)) {
                    diff1.add(s);
                }
            }

            for (int s : set2) {
                if (!set1.contains(s)) {
                    diff2.add(s);
                }
            }

            return Arrays.asList(diff1, diff2);
        }
    }
}
