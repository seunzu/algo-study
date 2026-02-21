package bfs;

import java.io.*;
import java.util.*;

// 숨바꼭질
public class boj_1697 {
    static int MAX = 100001;
    static int[] visited = new int[MAX];

    public static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == target) {
                System.out.println(visited[cur] - 1);
                return;
            }

            int[] next = {cur - 1, cur + 1, cur * 2};
            for (int n : next) {
                if (n >= 0 && n < MAX && visited[n] == 0) {
                    visited[n] = visited[cur] + 1;
                    q.offer(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
    }
}
