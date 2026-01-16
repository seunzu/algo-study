package silver.s2;

import java.io.*;
import java.util.*;

// 알고리즘 수업 - 깊이 우선 탐색 2
public class boj_24480 {
    static int N, M, R;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] arr;
    static int cnt = 1;

    static void dfs(int node) {
        visited[node] = true;
        arr[node] = cnt++;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
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
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
