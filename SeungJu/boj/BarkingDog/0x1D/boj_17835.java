package Dijkstra;

import java.io.*;
import java.util.*;

// 면접보는 승범이네
public class boj_17835 {
    static class Node implements Comparable<Node> {
        int to;
        long cost;

        public Node(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static int N, M, K;
    static List<List<Node>> graph;
    static int[] starts;
    static final long INF = Long.MAX_VALUE;

    static long[] dijkstra() {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pQ = new PriorityQueue<>();

        for (int s : starts) {
            dist[s] = 0;
            pQ.offer(new Node(s, 0));
        }

        while (!pQ.isEmpty()) {
            Node cur = pQ.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Node next : graph.get(cur.to)) {
                long newCost = cur.cost + next.cost;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pQ.offer(new Node(next.to, newCost));
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
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(V).add(new Node(U, C));
        }

        starts = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            starts[i] = Integer.parseInt(st.nextToken());
        }

        long[] dist = dijkstra();

        long city = -1;
        long max = -1;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > max) {
                max = dist[i];
                city = i;
            }
        }

        System.out.println(city);
        System.out.println(max);
    }
}
