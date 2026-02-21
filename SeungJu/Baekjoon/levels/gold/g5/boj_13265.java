package gold.g5;

import java.io.*;
import java.util.*;

// 색칠하기
public class boj_13265 {
    static List<List<Integer>> graph;
    static int[] color;

    static boolean bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        color[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (color[next] == 0) {
                    color[next] = -color[cur];
                    q.offer(next);
                } else if (color[next] == color[cur]) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            color = new int[n];
            boolean isBipartite = true;

            for (int i = 0; i < n; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            sb.append(isBipartite ? "possible" : "impossible").append("\n");
        }

        System.out.println(sb);
    }
}
