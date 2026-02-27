package LeetCode75.Stack;

// Decode String
public class leetcode_394 {
    class Solution {
        public String decodeString(String s) {
            Stack<Integer> cntStack = new Stack<>();
            Stack<StringBuilder> stringStack = new Stack<>();

            StringBuilder cur = new StringBuilder();
            int k = 0;

            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    k = k * 10 + (c - '0');
                } else if (c == '[') {
                    cntStack.push(k);
                    stringStack.push(cur);

                    cur = new StringBuilder();
                    k = 0;
                } else if (c == ']') {
                    int repeat = cntStack.pop();
                    StringBuilder prev = stringStack.pop();
                    for (int i = 0; i < repeat; i++) {
                        prev.append(cur);
                    }
                    cur = prev;
                } else cur.append(c);
            }

            return cur.toString();
        }
    }
}
