package 미로탈출;

import java.util.*;

class Solution {
    static int n, m;
    static boolean[][] visited;
    static int[][] dist;
    static String[] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int bfs(int sx, int sy, char target) {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
            Arrays.fill(dist[i], 0);
        }

        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (map[x].charAt(y) == target) return dist[x][y];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (map[nx].charAt(ny) == 'X') continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        return -1;
    }

    public int solution(String[] maps) {
        map = maps;
        n = maps.length;
        m = maps[0].length();

        visited = new boolean[n][m];
        dist = new int[n][m];

        int sx = 0, sy = 0, lx = 0, ly = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }

        int toLever = bfs(sx, sy, 'L');
        if (toLever == -1) return -1;

        int toExit = bfs(lx, ly, 'E');
        if (toExit == -1) return -1;

        return toLever + toExit;
    }
}