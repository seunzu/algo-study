package greedy;

import java.io.*;
import java.util.*;

// 동전 0
public class boj_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int min = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] <= K) {
                min += (K / A[i]);
                K %= A[i];
            }
        }

        System.out.println(min);
    }
}
