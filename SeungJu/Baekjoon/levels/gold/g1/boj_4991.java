package gold.g1;

import java.io.*;
import java.util.*;

// 로봇 청소기
public class boj_4991 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int w, h;
    static char[][] room;
    static List<Point> points;
    static int[][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans;

    static int[] bfs(Point start) {
        int[][] visited = new int[h][w];
        for (int[] row : visited) Arrays.fill(row, -1);

        Queue<Point> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (room[nx][ny] == 'x') continue;
                if (visited[nx][ny] != -1) continue;

                visited[nx][ny] = visited[cur.x][cur.y] + 1;
                q.offer(new Point(nx, ny));
            }
        }

        int[] res = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            res[i] = visited[p.x][p.y];
        }

        return res;
    }

    static void dfs(int cur, int cnt, int sum, boolean[] visited) {
        if (cnt == points.size() - 1) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 1; i < points.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1, sum + dist[cur][i], visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            room = new char[h][w];
            points = new ArrayList<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    room[i][j] = line.charAt(j);
                    if (room[i][j] == 'o') points.add(0, new Point(i, j));
                    else if (room[i][j] == '*') points.add(new Point(i, j));
                }
            }

            int n = points.size();
            dist = new int[n][n];

            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                int[] d = bfs(points.get(i));
                for (int j = 0; j < n; j++) {
                    dist[i][j] = d[j];
                    if (d[j] == -1) impossible = true;
                }
            }

            if (impossible) {
                System.out.println(-1);
                continue;
            }

            ans = Integer.MAX_VALUE;
            boolean[] visited = new boolean[n];
            visited[0] = true;

            dfs(0, 0, 0, visited);

            System.out.println(ans);
        }
    }
}
