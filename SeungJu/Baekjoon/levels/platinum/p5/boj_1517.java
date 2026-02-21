package platinum.p5;

import java.io.*;
import java.util.*;

// 버블 소트
public class boj_1517 {
    static int N;
    static int[] A, tmp;
    static long cnt = 0;

    static void mergeSort(int lt, int rt) {
        if (lt >= rt) return;

        int mid = (lt + rt) / 2;
        mergeSort(lt, mid);
        mergeSort(mid + 1, rt);
        merge(lt, mid, rt);
    }

    static void merge(int lt, int mid, int rt) {
        int i = lt;
        int j = mid + 1;
        int idx = lt;

        while (i <= mid && j <= rt) {
            if (A[i] <= A[j]) tmp[idx++] = A[i++];
            else {
                tmp[idx++] = A[j++];
                cnt += (mid - i + 1);
            }
        }

        while (i <= mid) tmp[idx++] = A[i++];
        while (j <= rt) tmp[idx++] = A[j++];

        for (int k = lt; k <= rt; k++) A[k] = tmp[k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());

        A = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);
        System.out.println(cnt);
    }
}
