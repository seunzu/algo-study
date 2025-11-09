package gold;

import java.io.*;
import java.util.*;

// 집합의 표현
public class boj_1717 {
    static int[] unf;

    static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) Union(a, b);
            else {
                if (Find(a) == Find(b)) sb.append("YES").append('\n');
                else sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);
    }
}
