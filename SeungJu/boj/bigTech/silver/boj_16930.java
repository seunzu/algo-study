package silver;

import java.io.*;
import java.util.*;

// 달리기
public class boj_16930 {
    static int N, M, K;
    static char[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        dist[x][y] = 0;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                for (int k = 1; k <= K; k++) {
                    int nx = cur[0] + dx[dir] * k;
                    int ny = cur[1] + dy[dir] * k;

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) break;
                    if (map[nx][ny] == '#') break;
                    if (dist[nx][ny] != -1 && dist[nx][ny] <= dist[cur[0]][cur[1]]) break;

                    if (dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;

        dist = new int[N][M];
        for (int[] row : dist) Arrays.fill(row, -1);

        bfs(x1, y1);
        System.out.println(dist[x2][y2]);
    }
}
