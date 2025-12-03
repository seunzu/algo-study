package graph;

import java.io.*;
import java.util.*;

// 환승
public class boj_5124 {
    static int N, K, M;
    static List<List<Integer>> graph;

    static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        int[] dist = new int[N + M + 1];
        Arrays.fill(dist, -1);
        dist[1] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    if (next > N) dist[next] = dist[cur];
                    else dist[next] = dist[cur] + 1;

                    q.offer(next);
                }
            }
        }

        return dist[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N + M; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int tube = N + i;

            for (int j = 0; j < K; j++) {
                int station = Integer.parseInt(st.nextToken());

                graph.get(station).add(tube);
                graph.get(tube).add(station);
            }
        }

        System.out.println(bfs());
    }
}
