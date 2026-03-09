package LeetCode75.BinarySearch;

// Find Peak Element
public class leetcode_162 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int lt = 1;
            int rt = nums.length - 1;

            while (lt < rt) {
                int mid = (lt + rt) / 2;

                if (nums[mid] > nums[mid + 1]) {
                    rt = mid;
                } else lt = mid + 1;
            }

            return lt;
        }
    }
}
