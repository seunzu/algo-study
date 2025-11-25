package gold;

import java.io.*;
import java.util.*;

// 이분 그래프
public class boj_1707 {
    static int[] color;
    static List<List<Integer>> graph;
    static boolean flag;

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (color[next] == 0) {
                    color[next] = -color[cur];
                    queue.offer(next);
                } else if (color[next] == color[cur]) {
                    flag = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            color = new int[V + 1];
            flag = true;

            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) bfs(i);
            }

            sb.append(flag ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
