package floydWarshall;

import java.io.*;
import java.util.*;

// 궁금한 민호
public class boj_1507 {
    static int N;
    static int[][] dist;
    static boolean[][] needed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        needed = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(needed[i], true);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    if (i == j || i == k || j == k) continue;

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        System.out.println(-1);
                        return;
                    }

                    if (dist[i][j] == dist[i][k] + dist[k][j]) {
                        needed[i][j] = false;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (needed[i][j]) ans += dist[i][j];
            }
        }

        System.out.println(ans);
    }
}
