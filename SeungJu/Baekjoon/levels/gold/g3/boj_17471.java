package gold.g3;

import java.io.*;
import java.util.*;

// 게리맨더링
public class boj_17471 {
    static int N;
    static int[] people;
    static List<List<Integer>> graph;

    static boolean bfs(int mask, boolean group) {
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            boolean inGroup = (mask & (1 << i)) != 0;
            if (inGroup == group) {
                q.offer(i);
                visited[i] = true;
                break;
            }
        }

        if (q.isEmpty()) return false;

        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    boolean inGroup = (mask & (1 << next)) != 0;
                    if (inGroup == group) {
                        visited[next] = true;
                        q.offer(next);
                        cnt++;
                    }
                }
            }
        }

        int total = 0;
        for (int i = 0; i < N; i++) {
            boolean inGroup = (mask & (1 << i)) != 0;
            if (inGroup == group) total++;
        }

        return cnt == total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        people = new int[N];
        graph = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                int adj = Integer.parseInt(st.nextToken()) - 1;
                graph.get(i).add(adj);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int mask = 1; mask < (1 << N) - 1; mask++) {
            if (!bfs(mask, true) || !bfs(mask, false)) continue;

            int sumA = 0, sumB = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) sumA += people[i];
                else sumB += people[i];
            }

            ans = Math.min(ans, Math.abs(sumA - sumB));
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
