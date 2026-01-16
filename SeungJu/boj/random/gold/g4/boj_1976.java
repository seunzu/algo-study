package gold.g4;

import java.io.*;
import java.util.*;

// 여행 가자
public class boj_1976 {
    static int[] unf;

    static int find(int v) {
        if (v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) unf[i] = i;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int root = find(start);
        boolean flag = true;

        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (find(next) != root) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }
}
