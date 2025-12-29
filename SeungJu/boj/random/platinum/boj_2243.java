package platinum;

import java.io.*;
import java.util.*;

// 사탕상자
public class boj_2243 {
    static int n;
    static int[] tree;
    static int size;
    static final int MAX = 1_000_000;

    static void update(int node, int start, int end, int idx, int diff) {
        if (idx < start || idx > end) return;

        tree[node] += diff;
        if (start == end) return;

        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, diff);
        update(node * 2 + 1, mid + 1, end, idx, diff);
    }

    static int query(int node, int start, int end, int k) {
        if (start == end) return start;

        int mid = (start + end) / 2;
        if (tree[node * 2] >= k) {
            return query(node * 2, start, mid, k);
        } else {
            return query(node * 2 + 1, mid + 1, end, k - tree[node * 2]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        size = 1;
        while (size < MAX) size <<= 1;
        tree = new int[size * 2];

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());

            if (A == 1) {
                int B = Integer.parseInt(st.nextToken());

                int taste = query(1, 1, MAX, B);
                sb.append(taste).append('\n');

                update(1, 1, MAX, taste, -1);
            } else {
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                update(1, 1, MAX, B, C);
            }
        }

        System.out.println(sb);
    }
}
