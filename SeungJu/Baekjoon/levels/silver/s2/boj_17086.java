package silver.s2;

import java.io.*;
import java.util.*;

// 아기 상어 2
class Point {
    int x, y, dist;

    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class boj_17086 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N][M];
        visited[x][y] = true;
        q.offer(new Point(x, y, 0));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (map[cur.x][cur.y] == 1) return cur.dist;

            for (int d = 0; d < 8; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, cur.dist + 1));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);
    }
}
