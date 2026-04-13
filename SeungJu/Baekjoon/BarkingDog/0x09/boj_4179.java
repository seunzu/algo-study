package bfs;

import java.io.*;
import java.util.*;

// 불!
public class boj_4179 {
    static int R, C;
    static char[][] map;
    static int[][] fire, jihoon;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<int[]> q1 = new ArrayDeque<>();
    static Queue<int[]> q2 = new ArrayDeque<>();

    static void bfsFire() {
        while (!q1.isEmpty()) {
            int[] cur = q1.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == '#' || fire[nx][ny] != -1) continue;

                fire[nx][ny] = fire[x][y] + 1;
                q1.offer(new int[]{nx, ny});
            }
        }
    }

    static int bfsJihoon() {
        while (!q2.isEmpty()) {
            int[] cur = q2.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
                return jihoon[x][y] + 1;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == '#' || jihoon[nx][ny] != -1) continue;
                if (fire[nx][ny] != -1 && fire[nx][ny] <= jihoon[x][y] + 1) continue;

                jihoon[nx][ny] = jihoon[x][y] + 1;
                q2.offer(new int[]{nx, ny});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fire = new int[R][C];
        jihoon = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fire[i], -1);
            Arrays.fill(jihoon[i], -1);
        }

        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'F') {
                    q1.offer(new int[]{i, j});
                    fire[i][j] = 0;
                } else if (map[i][j] == 'J') {
                    q2.offer(new int[]{i, j});
                    jihoon[i][j] = 0;
                }
            }
        }

        bfsFire();
        int res = bfsJihoon();

        System.out.println(res == -1 ? "IMPOSSIBLE" : res);
    }
}