package gold;

import java.io.*;
import java.util.*;

// 치즈
public class boj_2638 {
    static int N, M;
    static int[][] board;
    static boolean[][] air;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        air[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (air[nx][ny]) continue;

                if (board[nx][ny] == 0) {
                    air[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static int simulate() {
        int time = 0;

        while (true) {
            bfs();

            List<int[]> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1) {
                        int cnt = 0;

                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (air[nx][ny]) cnt++;
                        }

                        if (cnt >= 2) arr.add(new int[]{i, j});
                    }
                }
            }

            if (arr.isEmpty()) return time;

            for (int[] a : arr) board[a[0]][a[1]] = 0;

            time++;

            for (int i = 0; i < N; i++) Arrays.fill(air[i], false);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        air = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(simulate());
    }
}
