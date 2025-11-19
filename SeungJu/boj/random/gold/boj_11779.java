package gold;

import java.io.*;
import java.util.*;

// 최소비용 구하기 2
public class boj_11779 {
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

    static int n, m;
    static List<List<Node>> graph;
    static final int INF = Integer.MAX_VALUE;
    static int[] parent;

    static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(start, 0));

        while (!pQ.isEmpty()) {
            Node cur = pQ.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Node next : graph.get(cur.to)) {
                int nextCost = dist[cur.to] + next.cost;

                if (nextCost < dist[next.to]) {
                    dist[next.to] = nextCost;
                    parent[next.to] = cur.to;
                    pQ.offer(new Node(next.to, nextCost));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra(start);
        sb.append(dist[end]).append("\n");


        List<Integer> path = new ArrayList<>();
        int node = end;

        while (node != -1) {
            path.add(node);
            node = parent[node];
        }

        Collections.reverse(path);

        sb.append(path.size()).append("\n");

        for (int p : path) sb.append(p).append(" ");

        System.out.println(sb);
    }
}
