package gold;

import java.io.*;
import java.util.*;

// 최솟값
public class boj_10868 {
    static int N, M;
    static int[] arr;
    static int[] tree;

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    static int query(int node, int start, int end, int lt, int rt) {
        if (rt < start || end < lt) return Integer.MAX_VALUE;
        if (lt <= start && end <= rt) return tree[node];

        int mid = (start + end) / 2;
        return Math.min(
                query(node * 2, start, mid, lt, rt),
                query(node * 2 + 1, mid + 1, end, lt, rt)
        );
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        tree = new int[4 * N];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(query(1, 1, N, a, b)).append('\n');
        }

        System.out.println(sb);
    }
}
