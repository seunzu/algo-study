package gold;

import java.io.*;
import java.util.*;

// ACM Craft
public class boj_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] D = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] inDegree = new int[N + 1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X].add(Y);
                inDegree[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            int[] time = new int[N + 1];

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    q.offer(i);
                    time[i] = D[i];
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next : graph[cur]) {
                    time[next] = Math.max(time[next], time[cur] + D[next]);
                    inDegree[next]--;

                    if (inDegree[next] == 0) q.offer(next);
                }
            }

            sb.append(time[W]).append("\n");
        }

        System.out.println(sb);
    }
}
