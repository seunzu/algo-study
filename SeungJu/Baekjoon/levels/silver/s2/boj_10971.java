package silver.s2;

import java.io.*;
import java.util.*;

// 외판원 순회 2
public class boj_10971 {
    static int N;
    static int[][] W;
    static int[][] dp;
    static final int INF = 1_000_000_000;

    static int tsp(int start, int cur, int visited) {
        if (visited == (1 << N) - 1) {
            return W[cur][start] == 0 ? INF : W[cur][start];
        }

        if (dp[cur][visited] != -1) return dp[cur][visited];

        int minCost = INF;
        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) == 0 && W[cur][next] != 0) {
                int newVisited = visited | (1 << next);
                int cost = W[cur][next] + tsp(start, next, newVisited);
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[cur][visited] = minCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;
        for (int i = 0; i < N; i++) {
            dp = new int[N][1 << N];
            for (int[] row : dp) Arrays.fill(row, -1);

            answer = Math.min(answer, tsp(i, i, 1 << i));
        }

        System.out.println(answer);
    }
}
