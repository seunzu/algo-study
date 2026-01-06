package gold;

import java.io.*;
import java.util.*;

// 게임
public class boj_1103 {
    static int N, M;
    static int[][] board, dp;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean flag = false;

    static int dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return 0;
        if (board[x][y] == 0) return 0;

        if (visited[x][y]) {
            flag = true;
            return 0;
        }

        if (dp[x][y] != -1) return dp[x][y];

        visited[x][y] = true;
        int move = board[x][y];
        int max = 0;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d] * move;
            int ny = y + dy[d] * move;
            max = Math.max(max, dfs(nx, ny) + 1);
        }

        visited[x][y] = false;
        dp[x][y] = max;
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'H') board[i][j] = 0;
                else board[i][j] = line.charAt(j) - '0';
                dp[i][j] = -1;
            }
        }

        int ans = dfs(0, 0);
        System.out.println(flag ? -1 : ans);
    }
}
