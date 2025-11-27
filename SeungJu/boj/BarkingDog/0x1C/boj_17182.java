package floydWarshall;

import java.io.*;
import java.util.*;

// 우주 탐사선
public class boj_17182 {
    static int N, K;
    static int[][] dist;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    static void dfs(int start, int cnt, int cost) {
        if (cnt == N) {
            ans = Math.min(ans, cost);
            return;
        }

        for (int next = 0; next < N; next++) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, cnt + 1, cost + dist[start][next]);
                visited[next] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        visited[K] = true;
        dfs(K, 1, 0);

        System.out.println(ans);
    }
}
