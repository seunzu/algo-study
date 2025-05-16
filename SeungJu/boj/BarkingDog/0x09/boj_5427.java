package bfs;

import java.io.*;
import java.util.*;

// 불
public class boj_5427 {
    static int w, h;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q1;
    static Queue<int[]> q2;

    public static int bfs() {
        int time = 0;
        while (!q2.isEmpty()) {
            time++;
            bfsFire();
            if (bfsJihun()) return time;
        }

        return -1;
    }

    public static void bfsFire() {
        int size = q1.size();
        for (int i = 0; i < size; i++) {
            int[] cur = q1.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
                    map[nx][ny] = '*';
                    q1.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static boolean bfsJihun() {
        int size = q2.size();
        for (int i = 0; i < size; i++) {
            int[] cur = q2.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == 0 || y == 0 || x == h - 1 || y == w - 1) {
                return true;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (!visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        q2.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);

                    if (map[i][j] == '*') {
                        q1.offer(new int[]{i, j});
                    } else if (map[i][j] == '@') {
                        q2.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }

            int result = bfs();

            sb.append(result == -1 ? "IMPOSSIBLE" : result).append("\n");
        }

        System.out.print(sb);
    }
}
