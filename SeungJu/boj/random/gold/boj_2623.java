package gold;

import java.io.*;
import java.util.*;

// 음악프로그램
public class boj_2623 {
    static int N, M;
    static List<List<Integer>> graph;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        inDegree = new int[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());

            for (int i = 1; i < k; i++) {
                int cur = Integer.parseInt(st.nextToken());
                graph.get(prev).add(cur);
                inDegree[cur]++;
                prev = cur;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append("\n");
            cnt++;
            for (int next : graph.get(cur)) {
                if (--inDegree[next] == 0) q.offer(next);
            }
        }

        System.out.println(cnt != N ? 0 : sb);

    }
}
