package silver.s1;

import java.io.*;
import java.util.*;

// 전쟁 - 전투
public class boj_1303 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bfs(int x, int y, char color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (!visited[nx][ny] && map[nx][ny] == color) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    cnt++;
                }

            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int wPower = 0;
        int bPower = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int cnt = bfs(i, j, map[i][j]);

                    if (map[i][j] == 'W') wPower += cnt * cnt;
                    else bPower += cnt * cnt;
                }
            }
        }

        System.out.println(wPower + " " + bPower);
    }
}
