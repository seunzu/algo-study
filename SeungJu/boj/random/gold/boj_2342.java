package gold;

import java.io.*;
import java.util.*;

// Dance Dance Revolution
public class boj_2342 {
    static final int INF = 1_000_000_000;

    static int cost(int from, int to) {
        if (from == to) return 1;
        if (from == 0) return 2;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();
        while (true) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 0) break;
            arr.add(x);
        }

        int n = arr.size();
        int[][][] dp = new int[n + 1][5][5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            int next = arr.get(i);

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    int cur = dp[i][j][k];
                    if (cur == INF) continue;

                    if (next != k) {
                        dp[i + 1][next][k] = Math.min(
                                dp[i + 1][next][k],
                                cur + cost(j, next)
                        );
                    }

                    if (next != j) {
                        dp[i + 1][j][next] = Math.min(
                                dp[i + 1][j][next],
                                cur + cost(k, next)
                        );
                    }
                }
            }
        }

        int min = INF;
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                min = Math.min(min, dp[n][j][k]);
            }
        }

        System.out.println(min);
    }
}
