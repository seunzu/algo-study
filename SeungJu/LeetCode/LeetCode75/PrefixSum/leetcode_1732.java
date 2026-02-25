package LeetCode75.PrefixSum;

// Find the Highest Altitude
public class leetcode_1732 {
    class Solution {
        public int largestAltitude(int[] gain) {
            int cur = 0;
            int max = 0;

            for (int g : gain) {
                cur += g;
                max = Math.max(max, cur);
            }

            return max;
        }
    }
}
