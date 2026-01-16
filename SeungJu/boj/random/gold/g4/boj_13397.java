package gold.g4;

import java.io.*;
import java.util.*;

// 구간 나누기 2
public class boj_13397 {
    static int N, M;
    static int[] arr;

    static int countSections(int mid) {
        int cnt = 1;
        int min = arr[0], max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (max - min > mid) {
                cnt++;
                min = arr[i];
                max = arr[i];
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int lt = 0;
        int rt = 10_001;
        int result = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (countSections(mid) <= M) {
                result = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        System.out.println(result);
    }
}
