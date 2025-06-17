package etc;

import java.io.*;
import java.util.*;

// 외판원 순회
public class boj_2098 {
    static int N;
    static int[][] W;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static void dfs(int start, int now, int depth, int cost) {
        if (depth == N && W[now][start] != 0) {
            min = Math.min(min, cost + W[now][start]);
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs();
            visited[i] = false;
        }

        System.out.println(min);
    }
}
