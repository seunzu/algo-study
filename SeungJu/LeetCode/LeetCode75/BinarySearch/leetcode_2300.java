package LeetCode75.BinarySearch;

// Successful Pairs of Spells and Potions
public class leetcode_2300 {
    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);

            int n = spells.length;
            int m = potions.length;
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                long target = (success + spells[i] - 1) / spells[i];
                int lt = 0;
                int rt = m - 1;
                int idx = m;

                while (lt <= rt) {
                    int mid = lt + (rt - lt) / 2;

                    if (potions[mid] >= target) {
                        idx = mid;
                        rt = mid - 1;
                    } else lt = mid + 1;
                }

                result[i] = m - idx;
            }

            return result;
        }
    }
}
