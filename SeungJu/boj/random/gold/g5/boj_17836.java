package gold.g5;

import java.io.*;
import java.util.*;

// 공주님을 구해라!
public class boj_17836 {
    static int N, M, T;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], sword = cur[2], dist = cur[3];

            if (dist > T) continue;
            if (x == N - 1 && y == M - 1) return dist;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (board[nx][ny] == 0 && !visited[nx][ny][sword]) {
                    visited[nx][ny][sword] = true;
                    q.offer(new int[]{nx, ny, sword, dist + 1});
                }

                if (board[nx][ny] == 1 && sword == 1 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.offer(new int[]{nx, ny, 1, dist + 1});
                }

                if (board[nx][ny] == 2 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.offer(new int[]{nx, ny, 1, dist + 1});
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
        T = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M][2];
        int ans = bfs();

        if (ans == -1 || ans > T) System.out.println("Fail");
        else System.out.println(ans);
    }
}
