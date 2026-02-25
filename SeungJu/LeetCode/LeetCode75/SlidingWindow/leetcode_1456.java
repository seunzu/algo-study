package LeetCode75.SlidingWindow;

// Maximum Number of Vowels in a Substring of Given Length
public class leetcode_1456 {
    class Solution {
        static boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i'
                    || c == 'o' || c == 'u';
        }

        public int maxVowels(String s, int k) {
            int n = s.length();
            int cnt = 0;

            for (int i = 0; i < k; i++) {
                if (isVowel(s.charAt(i))) cnt++;
            }

            int max = cnt;
            for (int i = k; i < n; i++) {
                if (isVowel(s.charAt(i))) cnt++;
                if (isVowel(s.charAt(i - k))) cnt--;

                max = Math.max(max, cnt);

                if (max == k) return k;
            }

            return max;
        }
    }
}
