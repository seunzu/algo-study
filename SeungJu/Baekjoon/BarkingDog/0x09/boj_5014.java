package bfs;

import java.io.*;
import java.util.*;

// 스타트링크
public class boj_5014 {
    static int F, S, G, U, D;
    static int[] dist;

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        dist[S] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == G) return;

            int up = cur + U;
            if (up <= F && dist[up] == -1) {
                dist[up] = dist[cur] + 1;
                q.offer(up);
            }

            int down = cur - D;
            if (down >= 1 && dist[down] == -1) {
                dist[down] = dist[cur] + 1;
                q.offer(down);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[F + 1];
        Arrays.fill(dist, -1);
        bfs();

        if (dist[G] == -1) System.out.println("use the stairs");
        else System.out.println(dist[G]);
    }
}
