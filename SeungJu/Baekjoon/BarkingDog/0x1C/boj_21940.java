package floydWarshall;

import java.io.*;
import java.util.*;

// 가운데에서 만나기
public class boj_21940 {
    static final int INF = 1_000_000_000;;
    static int N, M, K;
    static int[][] dist;
    static int[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            dist[A][B] = T;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        K = Integer.parseInt(br.readLine());
        friends = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }

        int minMax = INF;
        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int max = 0;

            for (int friend : friends) {
                max = Math.max(max, dist[friend][i] + dist[i][friend]);
            }

            if (max < minMax) {
                minMax = max;
                arr.clear();
                arr.add(i);
            } else if (max == minMax) {
                arr.add(i);
            }
        }

        for (int i : arr) sb.append(i).append(" ");

        System.out.println(sb);
    }
}
