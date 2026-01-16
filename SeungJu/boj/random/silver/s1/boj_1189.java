package silver.s1;

import java.io.*;
import java.util.*;

// 컴백홈
public class boj_1189 {
    static int R, C, K;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans = 0;

    static void dfs(int x, int y, int dist) {
        if (x == 0 && y == C - 1) {
            if (dist == K) ans++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (board[nx][ny] == 'T') continue;
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, dist + 1);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(ans);
    }
}
