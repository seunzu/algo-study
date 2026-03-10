package LeetCode75.Backtracking;

// Letter Combinations of a Phone Number
public class leetcode_17 {
    class Solution {
        String[] map = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv",  "wxyz"
        };
        List<String> arr = new ArrayList<>();
        String digits;

        void dfs(int idx, StringBuilder path) {
            if (idx == digits.length()) {
                arr.add(path.toString());
                return;
            }

            String letters = map[digits.charAt(idx) - '0'];
            for (char c : letters.toCharArray()) {
                path.append(c);
                dfs(idx + 1, path);

                path.deleteCharAt(path.length() - 1);
            }
        }

        public List<String> letterCombinations(String digits) {
            this.digits = digits;

            if (digits.length() == 0) return arr;

            dfs(0, new StringBuilder());

            return arr;
        }
    }
}
