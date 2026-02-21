package LeetCode75.ArrayString;

// String Compression
public class leetcode_443 {
    class Solution {
        public int compress(char[] chars) {
            int n = chars.length;
            int write = 0;
            int read = 0;

            while (read < n) {
                char cur = chars[read];
                int cnt = 0;

                while (read < n && chars[read] == cur) {
                    read++;
                    cnt++;
                }

                chars[write++] = cur;

                if (cnt > 1) {
                    for (char c : String.valueOf(cnt).toCharArray()) {
                        chars[write++] = c;
                    }
                }
            }

            return write;
        }
    }
}
