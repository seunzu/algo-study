package gold;

import java.io.*;
import java.util.*;

// 트리의 순회
public class boj_2263 {
    static int n;
    static int[] in, post;
    static int[] idx;
    static StringBuilder sb = new StringBuilder();

    static void search(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = post[postEnd];
        sb.append(root).append(" ");

        int rootIdx = idx[root];
        int ltSize = rootIdx - inStart;

        search(inStart, rootIdx - 1, postStart, postStart + ltSize - 1);
        search(rootIdx + 1, inEnd, postStart + ltSize, postEnd - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        in = new int[n];
        post = new int[n];
        idx = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
            idx[in[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        search(0, n - 1, 0, n - 1);

        System.out.println(sb);
    }
}
