package dp;

import java.io.*;

// 피보나치 수의 확장
public class boj_1788 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        if (n < 0 && n % 2 == 0) sb.append(-1).append("\n");
        else if (n == 0) sb.append(0).append("\n");
        else sb.append(1).append("\n");

        n = Math.abs(n);
        long[] dp = new long[1_000_001];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        sb.append(dp[n]);
        System.out.println(sb);
    }
}
