package LeetCode75.TwoPointers;

// Container With Most Water
public class leetcode_11 {
    class Solution {
        public int maxArea(int[] height) {
            int lt = 0;
            int rt = height.length - 1;
            int max = 0;

            while (lt < rt) {
                int h = Math.min(height[lt], height[rt]);
                int width = rt - lt;
                max = Math.max(max, h * width);

                if (height[lt] < height[rt]) lt++;
                else rt--;
            }

            return max;
        }
    }
}
