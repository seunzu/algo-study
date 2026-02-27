package LeetCode75.Stack;

// Removing Stars From a String
public class leetcode_2390 {
    class Solution {
        public String removeStars(String s) {
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '*') stack.pop();
                else stack.push(c);
            }

            for (char c : stack) sb.append(c);

            return sb.toString();
        }
    }
}
