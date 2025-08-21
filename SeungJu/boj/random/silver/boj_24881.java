package silver;

import java.io.*;
import java.util.*;

// 알고리즘 수업 - 깊이 우선 탐색 3
public class boj_24881 {
    static int N, M, R;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] dist;

    static void dfs(int node, int depth) {
        visited[node] = true;
        dist[node] = depth;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, -1);

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(R, 0);

        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }
}
