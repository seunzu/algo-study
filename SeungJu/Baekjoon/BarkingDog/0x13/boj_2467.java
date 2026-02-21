package binarySearch;

import java.io.*;
import java.util.*;

// 용액
public class boj_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = N - 1;
        int ans1 = 0, ans2 = 0;

        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            int absSum = Math.abs(sum);

            if (absSum < min) {
                min = absSum;
                ans1 = arr[lt];
                ans2 = arr[rt];
            }

            if (sum < 0) lt++;
            else rt--;
        }

        System.out.println(ans1 + " " + ans2);
    }
}
