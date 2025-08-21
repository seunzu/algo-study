package silver;

import java.io.*;
import java.util.*;

// 알고리즘 수업 - 너비 우선 탐색 1
public class boj_24444 {
    static int N, M, R;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] arr;

    static void bfs(int strat) {
        Queue<Integer> q = new LinkedList<>();
        q.add(strat);
        visited[strat] = true;

        int cnt = 1;
        arr[strat] = cnt++;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    arr[next] = cnt++;
                    q.add(next);
                }
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
            Collections.sort(graph.get(i));
        }

        bfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
