package gold.g4;

import java.io.*;
import java.util.*;

// 고층 건물
public class boj_1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;

            long maxNum = Long.MIN_VALUE;
            long maxDen = 1;

            for (int j = i + 1; j < N; j++) {
                long num = arr[j] - arr[i];
                long den = j - i;

                if (maxNum * den < num * maxDen) {
                    cnt++;
                    maxNum = num;
                    maxDen = den;
                }
            }

            maxNum = Long.MIN_VALUE;
            maxDen = 1;

            for (int j = i - 1; j >= 0; j--) {

                long num = arr[j] - arr[i];
                long den = i - j;

                if (maxNum * den < num * maxDen) {
                    cnt++;
                    maxNum = num;
                    maxDen = den;
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
