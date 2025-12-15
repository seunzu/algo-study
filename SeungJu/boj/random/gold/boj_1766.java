package gold;

import java.io.*;
import java.util.*;

// 문제집
public class boj_1766 {
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

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            inDegree[B]++;
        }

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) pQ.offer(i);
        }

        while (!pQ.isEmpty()) {
            int cur = pQ.poll();
            sb.append(cur).append(" ");

            for (int next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) pQ.offer(next);
            }
        }

        System.out.println(sb);
    }
}
