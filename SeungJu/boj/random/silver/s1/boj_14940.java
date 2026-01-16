package silver.s1;

import java.io.*;
import java.util.*;

// 쉬운 최단거리
public class boj_14940 {
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 0) continue;
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];

        int sx = 0, sy = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
                if (map[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }

        bfs(sx, sy);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) sb.append(0).append(" ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
