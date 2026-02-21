package gold.g3;

import java.io.*;
import java.util.*;

// 경사로
public class boj_14890 {
    static int N, L;
    static int[][] map;

    static boolean check(int[] arr) {
        boolean[] used = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) continue;
            if (Math.abs(arr[i] - arr[i + 1]) > 1) return false;

            if (arr[i] - 1 == arr[i + 1]) {
                int height = arr[i + 1];

                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N) return false;
                    if (arr[j] != height) return false;
                    used[j] = true;
                }
            } else if (arr[i] + 1 == arr[i + 1]) {
                int height = arr[i];

                for (int j = i; j > i - L; j--) {
                    if (j < 0) return false;
                    if (arr[j] != height) return false;
                    if (used[j]) return false;
                    used[j] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (check(map[i])) ans++;
        }

        for (int j = 0; j < N; j++) {
            int[] col = new int[N];
            for (int i = 0; i < N; i++) {
                col[i] = map[i][j];
            }
            if (check(col)) ans++;
        }

        System.out.println(ans);
    }
}
