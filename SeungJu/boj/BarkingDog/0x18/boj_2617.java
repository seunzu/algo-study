package graph;

import java.io.*;
import java.util.*;

// 구슬 찾기
public class boj_2617 {
    static int N, M;
    static List<List<Integer>> heavy;
    static List<List<Integer>> light;

    static int bfs(List<List<Integer>> graph, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    q.offer(next);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        heavy = new ArrayList<>();
        light = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            heavy.add(new ArrayList<>());
            light.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            heavy.get(a).add(b);
            light.get(b).add(a);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int lightCnt = bfs(heavy, i);
            int heavyCnt = bfs(light, i);

            if (lightCnt > N / 2 || heavyCnt > N / 2) ans++;
        }

        System.out.println(ans);
    }
}
