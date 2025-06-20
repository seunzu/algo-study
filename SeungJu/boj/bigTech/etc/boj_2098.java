package etc;

import java.io.*;
import java.util.*;

// 외판원 순회
public class boj_2098 {
    static int N;
    static int[][] W;
    static int[][] dp;
    static final int INF = 1_000_000_000;

    static int tsp(int cur, int visited) {
        if (visited == (1 << N) - 1) {
            return W[cur][0] == 0 ? INF : W[cur][0];
        }

        if (dp[cur][visited] != -1) return dp[cur][visited];

        int minCost = INF;
        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) == 0 && W[cur][next] != 0) {
                int newVisited = visited | (1 << next);
                int cost = W[cur][next] + tsp(next, newVisited);
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[cur][visited] = minCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1 << 0));
    }
}
