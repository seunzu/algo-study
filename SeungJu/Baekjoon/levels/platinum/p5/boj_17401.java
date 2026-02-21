package platinum.p5;

import java.io.*;
import java.util.*;

// 일하는 세포
public class boj_17401 {
    static int T, N;
    static long D;
    static final long MOD = 1_000_000_007L;

    static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (A[i][k] == 0) continue;
                long aik = A[i][k];
                for (int j = 0; j < N; j++) {
                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    static long[][] power(long[][] base, long exp) {
        long[][] result = new long[N][N];
        for (int i = 0; i < N; i++) result[i][i] = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        D = Long.parseLong(st.nextToken());

        long[][][] day = new long[T][N][N];
        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                long c = Long.parseLong(st.nextToken());
                day[t][a][b] = (day[t][a][b] + c) % MOD;
            }
        }

        long[][] cycle = new long[N][N];
        for (int i = 0; i < N; i++) cycle[i][i] = 1;
        for (int t = 0; t < T; t++) {
            cycle = multiply(cycle, day[t]);
        }

        long full = D / T;
        int rem = (int) (D % T);
        long[][] result = power(cycle, full);

        for (int t = 0; t < rem; t++) {
            result = multiply(result, day[t]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
