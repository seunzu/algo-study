package bfs;

import java.io.*;
import java.util.*;

// 숨바꼭질
public class boj_1697 {
    static int MAX = 100001;
    static int[] time = new int[MAX];

    static void bfs(int s, int t) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[MAX];

        q.offer(s);
        visited[s] = true;
        time[s] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == t) {
                System.out.println(time[cur]);
                return;
            }

            int[] next = {cur - 1, cur + 1, cur * 2};
            for (int nx : next) {
                if (nx >= 0 && nx < MAX && !visited[nx]) {
                    visited[nx] = true;
                    time[nx] = time[cur] + 1;
                    q.offer(nx);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bfs(n, m);
    }
}
