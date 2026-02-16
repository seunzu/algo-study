package gold.g1;

import java.io.*;
import java.util.*;

// 수들의 합 7
public class boj_2268 {
    static int N, M;
    static long[] tree, arr;

    static long prefix(int i) {
        long sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= (i & -i);
        }
        return sum;
    }

    static long query(int lt, int rt) {
        return prefix(rt) - prefix(lt - 1);
    }

    static void update(int i, long diff) {
        while (i <= N) {
            tree[i] += diff;
            i += (i & -i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new long[N + 1];
        arr = new long[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 0) {
                int lt = Math.min(a, b);
                int rt = Math.max(a, b);
                sb.append(query(lt, rt)).append("\n");
            } else {
                long diff = b - arr[a];
                arr[a] = b;
                update(a, diff);
            }
        }

        System.out.println(sb);
    }
}
