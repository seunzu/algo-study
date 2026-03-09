package LeetCode75.BinarySearch;

// Koko Eating Bananas
public class leetcode_875 {
    class Solution {
        int[] piles;
        int h;

        boolean canFinish(int k) {
            int hours = 0;

            for (int p : piles) {
                hours += (p + k - 1) / k;
            }

            return hours <= h;
        }

        public int minEatingSpeed(int[] piles, int h) {
            this.piles = piles;
            this.h = h;

            int lt = 1;
            int rt = 0;

            for (int p : piles) {
                rt = Math.max(rt, p);
            }

            while (lt < rt) {
                int mid = (lt + rt) / 2;

                if (canFinish(mid)) rt = mid;
                else lt = mid + 1;
            }

            return lt;
        }
    }
}
