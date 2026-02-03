package 가운데글자가져오기;

class Solution {
    public String solution(String s) {
        int n = s.length();

        String ans = "";
        if (n % 2 == 0) {
            ans = s.substring(n / 2 - 1, n / 2 + 1);
        } else {
            ans = s.substring(n / 2, n / 2 + 1);
        }

        return ans;
    }
}