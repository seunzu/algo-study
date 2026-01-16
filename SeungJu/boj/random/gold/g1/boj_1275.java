package gold.g1;

import java.io.*;
import java.util.*;

// 커피숍2
public class boj_1275 {
    static int N, Q;
    static long[] arr, tree;

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

    static long query(int node, int start, int end, int lt, int rt) {
        if (rt < start || end < lt) return 0;
        if (lt <= start && end <= rt) return tree[node];

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, lt, rt)
                + query(node * 2 + 1, mid + 1, end, lt, rt);
    }

    static void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) return;

        tree[node] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, diff);
            update(node * 2 + 1, mid + 1, end, idx, diff);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[4 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        init(1, 1, N);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            int lt = Math.min(x, y);
            int rt = Math.max(x, y);

            sb.append(query(1, 1, N, lt, rt)).append('\n');

            long diff = b - arr[a];
            arr[a] = b;
            update(1, 1, N, a, diff);
        }

        System.out.println(sb);
    }
}
