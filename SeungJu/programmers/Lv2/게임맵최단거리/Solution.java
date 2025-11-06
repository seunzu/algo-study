package 게임맵최단거리;

import java.util.*;

class Solution {
    static int n, m;
    static boolean[][] visited;
    static int[] dx = {-1 , 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        return bfs(0, 0, maps);
    }
}