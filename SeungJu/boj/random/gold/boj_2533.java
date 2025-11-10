package gold;

import java.io.*;
import java.util.*;

// 사회망 서비스(SNS)
public class boj_2533 {
    static int N;
    static List<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;

    static void dfs(int v) {
        visited[v] = true;
        dp[v][0] = 0;
        dp[v][1] = 1;

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
                dp[v][0] += dp[next][1];
                dp[v][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}
