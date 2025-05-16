package binarySearch;

import java.io.*;
import java.util.*;

// 나무 자르기
public class boj_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int lt = 1, rt = max;
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            long total = 0;

            for (int i : arr) {
                if (i > mid) total += i - mid;
            }

            if (total >= M) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }
        System.out.println(answer);
    }
}
