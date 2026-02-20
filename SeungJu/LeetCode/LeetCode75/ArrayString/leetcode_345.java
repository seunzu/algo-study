package LeetCode75.ArrayString;

// Reverse Vowels of a String
public class leetcode_345 {
    class Solution {
        static boolean isVowel(char c) {
            return "aeiouAEIOU".indexOf(c) != -1;
        }

        public String reverseVowels(String s) {
            char[] arr = s.toCharArray();
            int lt = 0;
            int rt = arr.length - 1;

            while (lt < rt) {
                while (lt < rt && !isVowel(arr[lt])) lt++;
                while (lt < rt && !isVowel(arr[rt])) rt--;

                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;

                lt++;
                rt--;
            }

            return new String(arr);
        }
    }
}
