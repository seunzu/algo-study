package platinum;

import java.io.*;
import java.util.*;

// 구간 합 구하기 2
public class boj_10999 {
    static int N, M, K;
    static long[] arr, tree, lazy;

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void propagate(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];

            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static void update(int node, int start, int end, int lt, int rt, long diff) {
        propagate(node, start, end);

        if (rt < start || end < lt) return;
        if (lt <= start && end <= rt) {
            lazy[node] += diff;
            propagate(node, start, end);
            return;
        }
        tree[node] += diff;

        int mid = (start + end) / 2;
        update(node * 2, start, mid, lt, rt, diff);
        update(node * 2 + 1, mid + 1, end, lt, rt, diff);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int node, int start, int end, int lt, int rt) {
        propagate(node, start, end);

        if (rt < start || end < lt) return 0;
        if (lt <= start && end <= rt) return tree[node];

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, lt, rt)
                + query(node * 2 + 1, mid + 1, end, lt, rt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[4 * N];
        lazy = new long[4 * N];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());
                update(1, 1, N, b, c, d);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, N, b, c)).append('\n');
            }
        }

        System.out.println(sb);
    }
}
