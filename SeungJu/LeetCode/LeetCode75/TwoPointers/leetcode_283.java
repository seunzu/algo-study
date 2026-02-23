package LeetCode75.TwoPointers;

// Move Zeroes
public class leetcode_283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int lt = 0;

            for (int rt = 0; rt < nums.length; rt++) {
                if (nums[rt] != 0) {
                    int tmp = nums[lt];
                    nums[lt] = nums[rt];
                    nums[rt] = tmp;
                    lt++;
                }
            }
        }
    }
}
