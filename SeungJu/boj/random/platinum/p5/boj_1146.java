package platinum.p5;

import java.io.*;

// 지그재그 서기
public class boj_1146 {
    static final int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][N + 1];
        arr[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            arr[i][0] = arr[i][i] = 1;
            for (int j = 1; j < i; j++) {
                arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j]) % MOD;
            }
        }

        long[] dp = new long[N + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                long lt = (dp[j] + 1) / 2;
                long rt = (dp[i - 1 - j] + 1) / 2;
                dp[i] = (dp[i] + arr[i - 1][j] * lt % MOD * rt % MOD) % MOD;
            }
        }

        System.out.println(dp[N]);
    }
}