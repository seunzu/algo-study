package silver.s2;

import java.io.*;
import java.util.*;

// 예산
public class boj_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());

        int lt = 0;
        int rt = max;
        int ans = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.min(arr[i], mid);
            }

            if (sum <= M) {
                ans = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        System.out.println(ans);
    }
}
