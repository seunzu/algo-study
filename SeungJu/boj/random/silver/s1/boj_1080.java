package silver.s1;

import java.io.*;
import java.util.*;

// 행렬
public class boj_1080 {
    static int N, M;
    static int[][] A, B;

    public static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = s.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            A[x][y] = 1 - A[x][y];
                        }
                    }
                    cnt++;
                }
            }
        }

        System.out.println(isSame() ? cnt : -1);
    }
}
