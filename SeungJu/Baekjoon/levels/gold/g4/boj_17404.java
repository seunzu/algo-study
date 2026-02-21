package gold.g4;

import java.io.*;
import java.util.*;

// RGB 거리 2
public class boj_17404 {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int ans = INF;
        for (int first = 0; first < 3; first++) {
            int[][] dp = new int[N + 1][3];

            for (int c = 0; c < 3; c++) {
                if (c == first) dp[1][c] = cost[1][c];
                else dp[1][c] = INF;
            }

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for (int last = 0; last < 3; last++) {
                if (last == first) continue;
                ans = Math.min(ans, dp[N][last]);
            }
        }

        System.out.println(ans);
    }
}
