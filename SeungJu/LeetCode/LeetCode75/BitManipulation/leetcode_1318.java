package LeetCode75.BitManipulation;

// Minimum Flips to Make a OR b Equal to c
public class leetcode_1318 {
    class Solution {
        public int minFlips(int a, int b, int c) {
            int flips = 0;

            while (a > 0 || b > 0 || c > 0) {
                int abit = a & 1;
                int bbit = b & 1;
                int cbit = c & 1;

                if (cbit == 1) {
                    if (abit == 0 && bbit == 0) flips++;
                } else flips += abit + bbit;

                a >>= 1;
                b >>= 1;
                c >>= 1;
            }

            return flips;
        }
    }
}
