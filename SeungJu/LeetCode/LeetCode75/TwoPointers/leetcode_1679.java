package LeetCode75.TwoPointers;

// Max Number of K-Sum Pairs
public class leetcode_1679 {class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int lt = 0;
        int rt = nums.length - 1;
        int cnt = 0;

        while (lt < rt) {
            int sum = nums[lt] + nums[rt];

            if (sum == k) {
                cnt++;
                lt++;
                rt--;
            } else if (sum < k) lt++;
            else rt--;
        }

        return cnt;
    }
}
}
