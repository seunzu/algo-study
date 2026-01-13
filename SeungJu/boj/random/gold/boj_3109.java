package gold;

import java.io.*;
import java.util.*;

// 빵집
public class boj_3109 {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};
    static int cnt = 0;

    static boolean dfs(int r, int c) {
        if (c == C - 1) {
            return true;
        }

        for (int d = 0; d < 3; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if (visited[nr][nc] || map[nr][nc] == 'x') continue;
            visited[nr][nc] = true;

            if (dfs(nr, nc)) return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            visited[i][0] = true;
            if (dfs(i, 0)) cnt++;
        }

        System.out.println(cnt);
    }
}
