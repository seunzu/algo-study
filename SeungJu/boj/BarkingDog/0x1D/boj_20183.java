package Dijkstra;

import java.io.*;
import java.util.*;

// 골목 대장 호석 - 효율성2
public class boj_20183 {
    static class Edge implements Comparable<Edge> {
        int to;
        long cost;

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static int N, M, A, B;
    static long C;
    static List<List<Edge>> graph;
    static final long INF = Long.MAX_VALUE;

    static boolean dijkstra(long limit) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[A] = 0;

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(A, 0));

        while (!pQ.isEmpty()) {
            Edge cur = pQ.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Edge next : graph.get(cur.to)) {
                if (next.cost > limit) continue;

                long newCost = cur.cost + next.cost;

                if (newCost < dist[next.to] && newCost <= C) {
                    dist[next.to] = newCost;
                    pQ.offer(new Edge(next.to, newCost));
                }
            }
        }

        return dist[B] != INF;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        long max = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
            max = Math.max(max, w);
        }

        long lt = 0, rt = max;
        long ans = -1;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            if (dijkstra(mid)) {
                ans = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        System.out.println(ans);
    }
}
