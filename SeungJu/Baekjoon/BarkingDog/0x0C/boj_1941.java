package backtracking;

import java.io.*;
import java.util.*;

// 소문난 칠공주
public class boj_1941 {
    static char[][] map = new char[5][5];
    static int[] arr = new int[7];
    static boolean[] visited = new boolean[25];
    static int count = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int at, int depth) {
        if (depth == 7) {
            if (isValid()) count++;
            return;
        }

        for (int i = at; i < 25; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isValid() {
        int sCount = 0;
        for (int i = 0; i < 7; i++) {
            int x = arr[i] / 5;
            int y = arr[i] % 5;
            if (map[x][y] == 'S') sCount++;
        }
        return sCount >= 4 && bfs();
    }

    public static boolean bfs() {
        boolean[][] isSelected = new boolean[5][5];
        for (int i = 0; i < 7; i++) {
            int x = arr[i] / 5;
            int y = arr[i] % 5;
            isSelected[x][y] = true;
        }

        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new ArrayDeque<>();

        int startX = arr[0] / 5;
        int startY = arr[0] % 5;

        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        int connected = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (visited[nx][ny]) continue;
                if (!isSelected[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                connected++;
            }
        }

        return connected == 7;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0);
        System.out.println(count);
    }
}
