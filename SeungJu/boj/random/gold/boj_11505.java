package gold;

import java.io.*;
import java.util.*;

// 구간 곱 구하기
public class boj_11505 {
    static int N, M, K;
    static long[] arr, tree;
    static final long MOD = 1_000_000_007L;

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start] % MOD;
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
    }

    static void update(int node, int start, int end, int idx, long val) {
        if (idx < start || idx > end) return;

        if (start == end) {
            tree[node] = val % MOD;
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, val);
        update(node * 2 + 1, mid + 1, end, idx, val);
        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
    }

    static long query(int node, int start, int end, int lt, int rt) {
        if (rt < start || end < lt) return 1;
        if (lt <= start && end <= rt) return tree[node];

        int mid = (start + end) / 2;
        return (query(node * 2, start, mid, lt, rt)
                * query(node * 2 + 1, mid + 1, end, lt, rt)) % MOD;
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

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) update(1, 1, N, b, c);
            else sb.append(query(1, 1, N, b, (int) c)).append('\n');
        }

        System.out.println(sb);
    }
}
