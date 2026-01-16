package silver.s3;

import java.io.*;

// 달팽이
public class boj_1913 {
    static int N, M;
    static int[][] map;
    // 반시계 방향: 위 → 오른쪽 → 아래 → 왼쪽
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void spiralFill() {
        int x = N / 2, y = N / 2;
        int num = 1;
        map[x][y] = num;

        int step = 1;
        int dir = 0;

        while (num < N * N) {
            for (int k = 0; k < 2; k++) {
                for (int s = 0; s < step; s++) {
                    if (num == N * N) return;
                    x += dx[dir];
                    y += dy[dir];
                    map[x][y] = ++num;
                }
                dir = (dir + 1) % 4;
            }
            step++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N][N];
        spiralFill();

        int ansX = 0, ansY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
                if (map[i][j] == M) {
                    ansX = i + 1;
                    ansY = j + 1;
                }
            }
            sb.append("\n");
        }

        sb.append(ansX).append(" ").append(ansY);
        System.out.println(sb);
    }
}
