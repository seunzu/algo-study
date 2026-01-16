package diamond.d5;

import java.io.*;
import java.util.*;

// 라면 사기 (small)
public class boj_18185 {
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N + 3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long cost = 0;
        for (int i = 1; i <= N; i++) {
            if (A[i + 1] > A[i + 2]) {
                int two = Math.min(A[i], A[i + 1] - A[i + 2]);
                if (two > 0) {
                    A[i] -= two;
                    A[i + 1] -= two;
                    cost += 5L * two;
                }
            }

            int three = Math.min(A[i], Math.min(A[i + 1], A[i + 2]));
            if (three > 0) {
                A[i] -= three;
                A[i + 1] -= three;
                A[i + 2] -= three;
                cost += 7L * three;
            }

            int two = Math.min(A[i], A[i + 1]);
            if (two > 0) {
                A[i] -= two;
                A[i + 1] -= two;
                cost += 5L * two;
            }

            if (A[i] > 0) {
                cost += 3L * A[i];
                A[i] = 0;
            }
        }

        System.out.println(cost);
    }
}
