package silver.s3;

import java.io.*;
import java.util.*;

// 바이러스
public class boj_2606 {
    static int N, M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int cnt = 0;

    static void dfs(int node) {
        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                cnt++;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[N + 1];

        dfs(1);

        System.out.println(cnt);
    }
}
