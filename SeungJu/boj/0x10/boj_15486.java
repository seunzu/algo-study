package dp;

import java.io.*;
import java.util.*;

// 퇴사 2
public class boj_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        long[] dp = new long[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }

        long max = 0;
        for (int i = 1; i <= N + 1; i++) max = Math.max(max, dp[i]);

        System.out.println(max);
    }
}
