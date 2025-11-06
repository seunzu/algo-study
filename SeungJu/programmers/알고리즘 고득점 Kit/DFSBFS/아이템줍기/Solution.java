package DFSBFS.아이템줍기;

import java.util.*;

class Solution {
    static int[][] board = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int bfs(int x, int y, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == targetX && cur[1] == targetY) {
                return cur[2];
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }

        return 0;
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    board[i][j] = 1;
                }
            }
        }

        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;
            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    board[i][j] = 0;
                }
            }
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }
}