package gold;

import java.io.*;
import java.util.*;

// 뱀과 사다리 게임
public class boj_16928 {
    static int N, M;
    static int[] board;
    static boolean[] visited;

    static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int cnt = cur[1];

            if (pos == 100) return cnt;

            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next > 100) continue;

                next = board[next];
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[101];
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v;
        }

        visited = new boolean[101];

        System.out.println(bfs(1));
    }
}
