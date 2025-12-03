package graph;

import java.io.*;
import java.util.*;

// 숨바꼭질
public class boj_6118 {
    static int N, M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] dist;

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        visited = new boolean[N + 1];
        dist = new int[N + 1];

        bfs();

        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }

        int idx = -1;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == maxDist) {
                if (idx == -1) idx = i;
                cnt++;
            }
        }

        System.out.println(idx + " " + maxDist + " " + cnt);
    }
}
