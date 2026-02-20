package LeetCode75.ArrayString;

// Can Place Flowers
public class leetcode_605 {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int len = flowerbed.length;
            int cnt = 0;

            for (int i = 0; i < len; i++) {
                if (flowerbed[i] == 0 &&
                        (i == 0 || flowerbed[i - 1] == 0) &&
                        (i == len - 1 || flowerbed[i + 1] == 0)) {

                    flowerbed[i] = 1;
                    cnt++;

                    if (cnt >= n) return true;
                }
            }

            return cnt >= n;
        }
    }
}
