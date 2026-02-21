package gold.g4;

import java.io.*;
import java.util.*;

// 팀 배분
public class boj_1953 {
    static List<List<Integer>> graph;
    static int[] team;

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        team[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (team[next] == 0) {
                    team[next] = -team[cur];
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                int x = Integer.parseInt(st.nextToken());
                graph.get(i).add(x);
            }
        }

        team = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (team[i] == 0) bfs(i);
        }

        List<Integer> blue = new ArrayList<>();
        List<Integer> white = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (team[i] == 1) blue.add(i);
            else white.add(i);
        }

        sb.append(blue.size()).append("\n");
        for (int b : blue) sb.append(b).append(" ");
        sb.append("\n");

        sb.append(white.size()).append("\n");
        for (int w: white) sb.append(w).append(" ");

        System.out.println(sb);
    }
}
