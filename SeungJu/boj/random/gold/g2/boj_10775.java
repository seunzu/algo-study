package gold.g2;

import java.io.*;

// 공항
public class boj_10775 {
    static int G, P;
    static int[] unf;

    static int find(int v) {
        if (v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        unf = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            unf[i] = i;
        }

        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int gate = Integer.parseInt(br.readLine());

            int available = find(gate);
            if (available == 0) break;

            union(available, available - 1);
            cnt++;
        }
        System.out.println(cnt);
    }
}
