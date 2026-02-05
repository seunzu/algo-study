package 숫자문자열과영단어;

class Solution {
    static String[] words = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };

    public int solution(String s) {
        for (int i = 0; i < 10; i++) {
            s = s.replace(words[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}
