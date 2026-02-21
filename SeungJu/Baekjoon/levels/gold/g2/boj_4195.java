package gold.g2;

import java.io.*;
import java.util.*;

// 친구 네트워크
public class boj_4195 {
    static int[] unf, size;

    static int find(int v) {
        if (v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }

    static int union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fb] = fa;
            size[fa] += size[fb];
        }
        return size[fa];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());

            unf = new int[F * 2];
            size = new int[F * 2];
            for (int j = 0; j < F * 2; j++) {
                unf[j] = j;
                size[j] = 1;
            }

            Map<String, Integer> HM = new HashMap<>();
            int idx = 0;
            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!HM.containsKey(a)) HM.put(a, idx++);
                if (!HM.containsKey(b)) HM.put(b, idx++);

                int res = union(HM.get(a), HM.get(b));
                sb.append(res).append('\n');
            }
        }

        System.out.println(sb);
    }
}
