package gold;

import java.io.*;
import java.util.*;

// 벽 부수고 이동하기
public class boj_2206 {
    static int N, M;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], broken = cur[2], dist = cur[3];

            if (x == N - 1 && y == M - 1) return dist;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (board[nx][ny] == 0 && !visited[nx][ny][broken]) {
                    visited[nx][ny][broken] = true;
                    q.offer(new int[]{nx, ny, broken, dist + 1});
                }

                if (board[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
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

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M][2];

        System.out.println(bfs());
    }
}
