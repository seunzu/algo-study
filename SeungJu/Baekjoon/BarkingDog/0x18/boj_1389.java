package graph;

import java.io.*;
import java.util.*;

// 케빈 베이컨의 6단계 법칙
public class boj_1389 {
    static int N, M;
    static List<List<Integer>> graph;
    static boolean[] visited;

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        int[] dist = new int[N + 1];
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

        int sum = 0;
        for (int i = 1; i <= N; i++) sum += dist[i];

        return sum;
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

        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int sum = bfs(i);
            if (sum < min) {
                min = sum;
                ans = i;
            }
        }

        System.out.println(ans);
    }
}