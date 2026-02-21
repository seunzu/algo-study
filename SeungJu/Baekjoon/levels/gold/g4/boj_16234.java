package gold.g4;

import java.io.*;
import java.util.*;

// 인구 이동
public class boj_16234 {
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static List<int[]> bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> union = new ArrayList<>();

        visited[x][y] = true;
        q.offer(new int[]{x, y});
        union.add(new int[]{x, y});

        int sum = A[x][y];
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(A[cur[0]][cur[1]] - A[nx][ny]);
                if (L <= diff && diff <= R) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    sum += A[nx][ny];
                }
            }
        }

        int avg = sum / union.size();
        for (int[] u :union) A[u[0]][u[1]] = avg;
        return union;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j);

                        if (union.size() > 1) flag = true;
                    }
                }
            }

            if (!flag) break;
            days++;
        }

        System.out.println(days);
    }
}
