package gold.g3;

import java.io.*;
import java.util.*;

// 세 용액
public class boj_2473 {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long best = Long.MAX_VALUE;
        long a = 0, b = 0, c = 0;

        for (int i = 0; i < N - 2; i++) {
            int lt = i + 1;
            int rt = N - 1;

            while (lt < rt) {
                long sum = arr[i] + arr[lt] + arr[rt];
                long abs = Math.abs(sum);

                if (abs < best) {
                    best = abs;
                    a = arr[i];
                    b = arr[lt];
                    c = arr[rt];
                }

                if (sum > 0) rt--;
                else lt++;
            }
        }

        System.out.println(a + " " + b + " " + c);
    }
}
