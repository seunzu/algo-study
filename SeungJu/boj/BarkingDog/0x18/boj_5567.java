package graph;

import java.io.*;
import java.util.*;

// 결혼식
public class boj_5567 {
    static int n, m;
    static List<List<Integer>> graph;
    static boolean[] visited;

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int depth = cur[1];

            if (depth == 2) continue;

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    q.offer(new int[]{next, depth + 1});
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n + 1];

        System.out.println(bfs());
    }
}
