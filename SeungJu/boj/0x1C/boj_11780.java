package floydWarshall;

import java.io.*;
import java.util.*;

// 플로이드 2
public class boj_11780 {
    static final int INF = 1_000_000_000;;
    static int[][] dist, path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];
        path = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (c < dist[a][b]) {
                dist[a][b] = c;
                path[a][b] = b;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) sb.append("0 ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF || i == j) {
                    sb.append("0\n");
                } else {
                    List<Integer> arr = new ArrayList<>();
                    int cur = i;
                    while (cur != j) {
                        arr.add(cur);
                        cur = path[cur][j];
                    }
                    arr.add(j);

                    sb.append(arr.size()).append(" ");
                    for (int city : arr) sb.append(city).append(" ");
                    sb.append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
