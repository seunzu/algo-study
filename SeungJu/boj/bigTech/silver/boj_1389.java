package silver;

import java.io.*;
import java.util.*;

// 케빈 베이컨의 6단계 법칙
public class boj_1389 {
    static int N, M;
    static ArrayList<Integer>[] graph;

    static int bfs(int start) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            graph[B].add(A);
        }

        int min = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);
            if (sum < min) {
                min = sum;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
