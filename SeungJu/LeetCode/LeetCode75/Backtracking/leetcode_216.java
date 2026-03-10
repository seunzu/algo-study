package LeetCode75.Backtracking;

// Combination Sum III
public class leetcode_216 {
    class Solution {
        int k;
        List<List<Integer>> arr = new ArrayList<>();

        void dfs(int start, int remain, List<Integer> path) {
            if (path.size() == k && remain == 0) {
                arr.add(new ArrayList<>(path));
                return;
            }

            if (path.size() > k || remain < 0) return;

            for (int i = start; i <= 9; i++) {
                path.add(i);
                dfs(i + 1, remain - i, path);
                path.remove(path.size() - 1);
            }
        }

        public List<List<Integer>> combinationSum3(int k, int n) {
            this.k = k;

            dfs(1, n, new ArrayList<>());

            return arr;
        }
    }
}
