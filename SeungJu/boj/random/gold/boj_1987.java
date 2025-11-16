package gold;

import java.io.*;
import java.util.*;

// 알파벳
public class boj_1987 {
    static int R, C;
    static char[][] board;
    static boolean[] visited = new boolean[26];
    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y, int cnt) {
        max = Math.max(max, cnt);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            char next = board[nx][ny];
            int idx = next - 'A';

            if (!visited[idx]) {
                visited[idx] = true;
                dfs(nx, ny, cnt + 1);
                visited[idx] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }
}
