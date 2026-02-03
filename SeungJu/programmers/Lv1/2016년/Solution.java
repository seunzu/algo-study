package 2016년;

class Solution {
    static String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    static int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String solution(int a, int b) {
        int ans = 0;

        for (int i = 0; i < a - 1; i++) {
            ans += days[i];
        }

        ans += b - 1;

        return week[ans % 7];
    }
}