package gold.g1;

import java.io.*;
import java.util.*;

// 수들의 합
public class boj_2268 {
    static int N, M;
    static long[] tree;
    static long[] arr;

    static long query(int node, int start, int end, int lt, int rt) {
        if (rt < start || end < lt) return 0;
        if (lt <= start && end <= rt) return tree[node];

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, lt, rt)
                + query(node * 2 + 1, mid + 1, end, lt, rt);
    }

    static void update(int node, int start, int end, int index, long diff) {
        if (index < start || index > end) return;

        tree[node] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, index, diff);
            update(node * 2 + 1, mid + 1, end, index, diff);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new long[4 * N];
        arr = new long[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 0) {
                int lt = Math.min(a, b);
                int rt = Math.max(a, b);
                sb.append(query(1, 1, N, lt, rt)).append("\n");
            } else {
                long diff = b - arr[a];
                arr[a] = b;
                update(1, 1, N, a, diff);
            }
        }

        System.out.print(sb);
    }
}