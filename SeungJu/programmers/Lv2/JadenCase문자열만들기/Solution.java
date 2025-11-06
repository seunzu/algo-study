package JadenCase문자열만들기;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        for (char c : s.toCharArray()) {
            if (flag) sb.append(Character.toUpperCase(c));
            else sb.append(Character.toLowerCase(c));
            flag = (c == ' ');
        }

        return sb.toString();
    }
}