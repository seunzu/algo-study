package bfs;

import java.io.*;
import java.util.*;

// 적록색약
public class boj_10026 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs(int x, int y, boolean isBlind) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        char color = map[x][y];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                char nextColor = map[nx][ny];

                if (isBlind) {
                    if ((color == 'R' || color == 'G') && (nextColor == 'R' || nextColor == 'G')) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    } else if (color == 'B' && nextColor == 'B') {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                } else {
                    if (color == nextColor) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][N];
        int normal = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    normal++;
                }
            }
        }

        visited = new boolean[N][N];
        int blind = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    blind++;
                }
            }
        }

        System.out.println(normal + " " + blind);
    }
}