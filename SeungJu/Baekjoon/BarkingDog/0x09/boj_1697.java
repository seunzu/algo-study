package bfs;

import java.io.*;
import java.util.*;

// 숨바꼭질
public class boj_1697 {
    static int N, K;
    static int[] dist;

    static int bfs(int start, int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == target) return dist[cur];
            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next > 100000) continue;
                if (dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }

        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        Arrays.fill(dist, -1);

        System.out.println(bfs(N, K));
    }
}
