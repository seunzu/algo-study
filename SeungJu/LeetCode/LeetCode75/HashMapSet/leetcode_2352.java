package LeetCode75.HashMapSet;

// Equal Row and Column Pairs
public class leetcode_2352 {
    class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;
            Map<String, Integer> HM = new HashMap<>();

            for (int[] g : grid) {
                String key = Arrays.toString(g);
                HM.put(key, HM.getOrDefault(key, 0) + 1);
            }

            int cnt = 0;
            for (int col = 0; col < n; col++) {
                int[] arr = new int[n];
                for (int row = 0; row < n; row++) {
                    arr[row] = grid[row][col];
                }

                String key = Arrays.toString(arr);
                cnt += HM.getOrDefault(key, 0);
            }

            return cnt;
        }
    }
}
