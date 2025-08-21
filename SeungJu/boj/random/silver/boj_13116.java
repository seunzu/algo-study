package silver;

import java.io.*;
import java.util.*;

// 30번
public class boj_13116 {
    public static int lca(int a, int b) {
        while (a != b) {
            if (a > b) a /= 2;
            else b /= 2;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append((lca(A, B)) * 10).append('\n');
        }

        System.out.println(sb);
    }
}
