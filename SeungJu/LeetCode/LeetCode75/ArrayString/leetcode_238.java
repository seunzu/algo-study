package LeetCode75.ArrayString;

// Product of Array Except Self
public class leetcode_238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];

            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i - 1] * nums[i - 1];
            }

            int rt = 1;
            for (int i = n - 1; i >= 0; i--) {
                dp[i] *= rt;
                rt *= nums[i];
            }

            return dp;
        }
    }
}
