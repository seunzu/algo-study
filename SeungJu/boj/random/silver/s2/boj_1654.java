package silver.s2;

import java.io.*;
import java.util.*;

// 랜선 자르기
public class boj_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long answer = 0;
        long lt = 1, rt = max;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long cnt = 0;

            for (int i : arr) {
                cnt += (i / mid);
            }

            if (cnt >= N) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        System.out.println(answer);
    }
}
