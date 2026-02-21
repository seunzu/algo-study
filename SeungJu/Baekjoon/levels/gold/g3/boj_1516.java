package gold.g3;

import java.io.*;
import java.util.*;

// 게임 개발
public class boj_1516 {
    static int N;
    static List<List<Integer>> graph;
    static int[] inDegree, time, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        inDegree = new int[N + 1];
        time = new int[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1) break;
                graph.get(pre).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            result[i] = time[i];
            if (inDegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                result[next] = Math.max(result[next], result[cur] + time[next]);
                inDegree[next]--;

                if (inDegree[next] == 0) q.offer(next);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }
}
