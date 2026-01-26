package 완전탐색.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int n = brown + yellow;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                int m = n / i;

                if ((i - 2) * (m - 2) == yellow) {
                    return new int[] {Math.max(i, m), Math.min(i, m)};
                }
            }
        }

        return null;
    }
}