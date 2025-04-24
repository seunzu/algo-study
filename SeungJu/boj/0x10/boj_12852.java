package dp;

import java.io.*;

// 1로 만들기 2
public class boj_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[] prev = new int[N + 1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
        }

        System.out.println(dp[N]);

        while (N > 0) {
            sb.append(N + " ");
            N = prev[N];
        }

        System.out.println(sb);
    }
}
