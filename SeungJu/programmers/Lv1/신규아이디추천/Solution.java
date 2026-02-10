package 신규아이디추천;

class Solution {
    public String solution(String new_id) {
        String s = new_id.toLowerCase();

        s = s.replaceAll("[^a-z0-9\\-_.]", "")
                .replaceAll("\\.+", ".")
                .replaceAll("^\\.|\\.$", "");

        if (s.isEmpty()) s = "a";

        if (s.length() >= 16) {
            s = s.substring(0, 15).replaceAll("\\.$", "");
        }

        while (s.length() <= 2) {
            s += s.charAt(s.length() - 1);
        }

        return s;
    }
}