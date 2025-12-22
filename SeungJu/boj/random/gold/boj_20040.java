package gold;

import java.io.*;
import java.util.*;

// 사이클 게임
public class boj_20040 {
    static int n, m;
    static int[] unf;

    static int find(int v) {
        if (v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fb] = fa;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        unf = new int[n];
        for (int i = 0; i < n; i++) unf[i] = i;

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) {
                ans = i;
                break;
            }
            union(a, b);
        }

        System.out.println(ans);
    }
}
