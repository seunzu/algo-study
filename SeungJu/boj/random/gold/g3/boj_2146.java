package gold.g3;

import java.io.*;
import java.util.*;

// 다리 만들기
public class boj_2146 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void labelIsland(int x, int y, int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = idx;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = idx;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static void bfs(int island) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visitedBfs = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == island) {
                    q.offer(new int[]{i, j, 0});
                    visitedBfs[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (dist >= ans) return;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visitedBfs[nx][ny]) continue;

                if (map[nx][ny] != 0 && map[nx][ny] != island) {
                    ans = Math.min(ans, dist);
                    return;
                }

                if (map[nx][ny] == 0) {
                    visitedBfs[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    labelIsland(i, j, idx);
                    idx++;
                }
            }
        }

        for (int i = 2; i < idx; i++) bfs(i);

        System.out.println(ans);
    }
}