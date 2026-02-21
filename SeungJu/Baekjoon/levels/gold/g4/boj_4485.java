package gold.g4;

import java.io.*;
import java.util.*;

// 녹색 옷을 입은 애가 젤다지?
public class boj_4485 {
    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N;
    static int[][] map, dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int INF = Integer.MAX_VALUE;

    static int dijkstra() {
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        dist[0][0] = map[0][0];
        pQ.offer(new Node(0, 0, map[0][0]));

        while (!pQ.isEmpty()) {
            Node cur = pQ.poll();

            if (cur.cost > dist[cur.x][cur.y]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                int nextCost = cur.cost + map[nx][ny];
                if (nextCost < dist[nx][ny]) {
                    dist[nx][ny] = nextCost;
                    pQ.offer(new Node(nx, ny, nextCost));
                }
            }
        }

        return dist[N - 1][N - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], INF);
            }

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(cnt++).append(": ").append(dijkstra()).append("\n");
        }

        System.out.println(sb);
    }
}
