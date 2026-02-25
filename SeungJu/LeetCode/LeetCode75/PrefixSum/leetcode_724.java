package LeetCode75.PrefixSum;

// Find Pivot Index
public class leetcode_724 {
    class Solution {
        public int pivotIndex(int[] nums) {
            int total = 0;
            for (int n : nums) {
                total += n;
            }

            int ltSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (ltSum == (total - ltSum - nums[i])) return i;
                ltSum += nums[i];
            }

            return -1;
        }
    }
}
