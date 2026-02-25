package LeetCode75.SlidingWindow;

// Longest Subarray of 1's After Deleting One Element
public class leetcode_1493 {
    class Solution {
        public int longestSubarray(int[] nums) {
            int lt = 0;
            int cnt = 0;
            int maxLen = 0;

            for (int rt = 0; rt < nums.length; rt++) {
                if (nums[rt] == 0) cnt++;

                while (cnt > 1) {
                    if (nums[lt] == 0) cnt--;
                    lt++;
                }

                maxLen = Math.max(maxLen, rt - lt + 1);
            }

            return maxLen - 1;
        }
    }
}
