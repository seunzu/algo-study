package gold.g4;

import java.io.*;
import java.util.*;

// 좋다
public class boj_1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        for (int k = 0; k < N; k++) {
            long target = arr[k];
            int lt = 0;
            int rt = N - 1;

            while (lt < rt) {
                if (lt == k) {
                    lt++;
                    continue;
                }
                if (rt == k) {
                    rt--;
                    continue;
                }

                long sum = arr[lt] + arr[rt];
                if (sum == target) {
                    cnt++;
                    break;
                } else if (sum < target) lt++;
                else rt--;
            }
        }

        System.out.println(cnt);
    }
}