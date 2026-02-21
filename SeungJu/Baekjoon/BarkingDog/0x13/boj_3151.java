package binarySearch;

import java.io.*;
import java.util.*;

// 합이 0
public class boj_3151 {
    static int N;
    public static int lowerBound(int[] arr, int s, int e, int target) {
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] < target) s = mid + 1;
            else e = mid;
        }
        return s;
    }

    public static int upperBound(int[] arr, int s, int e, int target) {
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] <= target) s = mid + 1;
            else e = mid;
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long count = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int target = -(arr[i] + arr[j]);
                int lt = lowerBound(arr, j + 1, N, target);
                int rt = upperBound(arr, j + 1, N, target);
                count += (rt - lt);
            }
        }
        System.out.println(count);
    }
}
