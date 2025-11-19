package gold;

import java.io.*;
import java.util.*;

// 최소비용 구하기
public class boj_1916 {
    static class Node implements Comparable<Node> {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N, M;
    static List<List<Node>> graph;

    static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(start, 0));

        while (!pQ.isEmpty()) {
            Node cur = pQ.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Node next : graph.get(cur.to)) {
                int newCost = cur.cost + next.cost;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pQ.offer(new Node(next.to, newCost));
                }
            }
        }

        return dist[end];
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
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(startCity).add(new Node(endCity, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }
}
