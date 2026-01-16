package gold.g3;

import java.io.*;
import java.util.*;

// 움직이는 미로 탈출
class Point {
    int x, y, t;

    Point (int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

public class boj_16954 {
    static char[][] map = new char[8][8];
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1, 0};

    static boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        boolean[][][] visited = new boolean[8][8][9];
        q.offer(new Point(7, 0, 0));
        visited[7][0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == 0 && cur.y == 7) return true;
            if (cur.t >= 8) return true;

            for (int d = 0; d < 9; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nt = Math.min(8, cur.t + 1);

                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
                if (cur.x - cur.t >= 0 && map[cur.x - cur.t][cur.y] == '#') continue;

                if (nx - cur.t >= 0 && map[nx - cur.t][ny] == '#') continue;
                if (nx - nt >= 0 && map[nx - nt][ny] == '#') continue;

                if (!visited[nx][ny][nt]) {
                    visited[nx][ny][nt] = true;
                    q.offer(new Point(nx, ny, nt));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs() ? 1 : 0);
    }
}
