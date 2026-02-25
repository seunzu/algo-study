package LeetCode75.SlidingWindow;

// Max Consecutive Ones III
public class leetcode_1004 {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int lt = 0;
            int cnt = 0;
            int max = 0;

            for (int rt = 0; rt < nums.length; rt++) {
                if (nums[rt] == 0) cnt++;

                while (cnt > k) {
                    if (nums[lt] == 0) cnt--;
                    lt++;
                }

                max = Math.max(max, rt - lt + 1);
            }

            return max;
        }
    }
}
