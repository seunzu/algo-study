package 땅따먹기;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];

        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int maxPrev = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    maxPrev = Math.max(maxPrev, dp[i - 1][k]);
                }
                dp[i][j] = land[i][j] + maxPrev;
            }
        }

        int answer = 0;
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, dp[n - 1][j]);
        }

        return answer;
    }
}