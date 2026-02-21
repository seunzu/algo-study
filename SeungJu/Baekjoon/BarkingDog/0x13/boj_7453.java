package binarySearch;

import java.io.*;
import java.util.*;

// 합이 0인 네 정수
public class boj_7453 {
    static int N;
    public static int lowerBound(int[] arr, int target) {
        int s = 0, e = arr.length;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] < target) s = mid + 1;
            else e = mid;
        }
        return s;
    }

    public static int upperBound(int[] arr, int target) {
        int s = 0, e = arr.length;
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
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[N * N];
        int[] CD = new int[N * N];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(CD);

        long count = 0;

        for (int i = 0; i < AB.length; i++) {
            int target = -AB[i];
            int lower = lowerBound(CD, target);
            int upper = upperBound(CD, target);
            count += (upper - lower);
        }

        System.out.println(count);
    }
}
