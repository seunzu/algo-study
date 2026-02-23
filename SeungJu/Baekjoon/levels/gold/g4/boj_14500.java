package gold.g4;

import java.io.*;
import java.util.*;

// 테트로미노
public class boj_14500 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max = 0;

    static void dfs(int r, int c, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, depth + 1, sum + board[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }

    static void checkT(int r, int c) {
        int center = board[r][c];
        int sum = center;
        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

            sum += board[nr][nc];
            min = Math.min(min, board[nr][nc]);
            cnt++;
        }

        if (cnt < 3) return;
        if (cnt == 4) sum -= min;

        max = Math.max(max, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;

                checkT(i, j);
            }
        }

        System.out.println(max);
    }
}