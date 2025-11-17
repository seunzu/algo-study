package gold;

import java.io.*;
import java.util.*;

// 파티
public class boj_1238 {
    static class Edge implements Comparable<Edge> {
        int to, time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }

    static int N, M, X;
    static List<Edge>[] graph, reverse;
    static int INF = 1_000_000_000;

    static int[] dijkstra(List<Edge>[] g, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pQ.isEmpty()) {
            Edge now = pQ.poll();
            int cur = now.to;
            int time = now.time;

            if (time > dist[cur]) continue;

            for (Edge next : g[cur]) {
                int nt = time + next.time;

                if (nt < dist[next.to]) {
                    dist[next.to] = nt;
                    pQ.offer(new Edge(next.to, nt));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverse = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, time));
            reverse[to].add(new Edge(from, time));
        }

        int[] fromX = dijkstra(graph, X);
        int[] toX = dijkstra(reverse, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, fromX[i] + toX[i]);
        }

        System.out.println(max);
    }
}
