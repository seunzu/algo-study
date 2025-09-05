package gold;

import java.io.*;
import java.util.*;

// 아기 상어
class Fish implements Comparable<Fish> {
    int x, y, dist;

    Fish(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Fish o) {
        if (this.dist == o.dist) {
            if (this.x == o.x) return this.y - o.y;
            return this.x - o.x;
        }
        return this.dist - o.dist;
    }
}

public class boj_16236 {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int simulate(int r, int c) {
        int size = 2;
        int eat = 0;
        int time = 0;

        while (true) {
            Fish target = bfs(r, c, size);
            if (target == null) break;

            time += target.dist;
            r = target.x;
            c = target.y;

            map[r][c] = 0;
            eat++;
            if (eat == size) {
                size++;
                eat = 0;
            }
        }

        return time;
    }

    static Fish bfs(int r, int c, int size) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0});
        visited[r][c] = true;

        PriorityQueue<Fish> pQ = new PriorityQueue<>();
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (dist > minDist) break;

            if (map[x][y] > 0 && map[x][y] < size) {
                pQ.offer(new Fish(x, y, dist));
                minDist = dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (!visited[nx][ny] && map[nx][ny] <= size) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        if (pQ.isEmpty()) return null;
        return pQ.poll();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int r = 0, c = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    r = i;
                    c = j;
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(simulate(r, c));
    }
}
