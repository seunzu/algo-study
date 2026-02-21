package diamond.d5;

import java.io.*;
import java.util.*;

// 라면 사기 (large)
public class boj_18186 {
    static int N;
    static long B, C;
    static long[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        A = new long[N + 3];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        long cost = 0;

        if (B <= C) {
            for (int i = 1; i <= N; i++) {
                cost += A[i] * B;
            }
            System.out.println(cost);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (A[i + 1] > A[i + 2]) {
                long two = Math.min(A[i], A[i + 1] - A[i + 2]);
                if (two > 0) {
                    A[i] -= two;
                    A[i + 1] -= two;
                    cost += two * (B + C);
                }
            }

            long three = Math.min(A[i], Math.min(A[i + 1], A[i + 2]));
            if (three > 0) {
                A[i] -= three;
                A[i + 1] -= three;
                A[i + 2] -= three;
                cost += three * (B + 2 * C);
            }

            long two = Math.min(A[i], A[i + 1]);
            if (two > 0) {
                A[i] -= two;
                A[i + 1] -= two;
                cost += two * (B + C);
            }

            if (A[i] > 0) {
                cost += A[i] * B;
                A[i] = 0;
            }
        }

        System.out.println(cost);
    }
}
