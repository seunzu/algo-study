package gold.g2;

import java.io.*;
import java.util.*;

// 방문 판매
public class boj_23748 {
    static final int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] x = new int[N + 1];
        int[] y = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[X + 1][Y + 1];
        int[][] last = new int[X + 1][Y + 1];

        for (int i = 0; i <= X; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int a = X; a >= 0; a--) {
                for (int b = Y; b >= 0; b--) {
                    if (dp[a][b] == INF) continue;

                    int newX = Math.min(X, a + x[i]);
                    int newY = Math.min(Y, b + y[i]);

                    if (dp[newX][newY] > dp[a][b] + 1) {
                        dp[newX][newY] = dp[a][b] + 1;
                        last[newX][newY] = i;
                    }
                }
            }
        }

        if (dp[X][Y] == INF) sb.append(-1);
        else sb.append(dp[X][Y]).append("\n").append(last[X][Y]);

        System.out.println(sb);
    }
}