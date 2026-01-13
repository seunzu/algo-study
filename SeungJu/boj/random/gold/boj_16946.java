package gold;

import java.io.*;
import java.util.*;

// 벽 부수고 이동하기 4
public class boj_16946 {
    static int N, M;
    static int[][] map, group;
    static boolean[][] visited;
    static int[] groupSize;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int x, int y, int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        group[x][y] = idx;

        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                group[nx][ny] = idx;
                cnt++;
                q.offer(new int[]{nx, ny});
            }
        }

        groupSize[idx] = cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        group = new int[N][M];
        visited = new boolean[N][M];
        groupSize = new int[N * M + 1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j, idx++);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    HashSet<Integer> set = new HashSet<>();
                    int sum = 1;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        int g = group[nx][ny];
                        if (g > 0 && set.add(g)) {
                            sum += groupSize[g];
                        }
                    }

                    sb.append(sum % 10);
                } else sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
