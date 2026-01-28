package 그리디.조이스틱;

class Solution {
    public int solution(String name) {
        int n = name.length();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            cnt += Math.min(c - 'A', 'Z' - c + 1);
        }

        int move = n - 1;
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') next++;

            move = Math.min(move, i * 2 + (n - next));
            move = Math.min(move, (n - next) * 2 + i);
        }

        return cnt + move;
    }
}