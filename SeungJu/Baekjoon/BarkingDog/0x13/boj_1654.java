package binarySearch;

import java.io.*;
import java.util.*;

// 랜선 자르기
public class boj_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long lt = 1, rt = max;
        long answer = 0;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long count = 0;
            for (int i : arr) count += (i / mid);

            if (count >= n) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }
        System.out.println(answer);
    }
}
