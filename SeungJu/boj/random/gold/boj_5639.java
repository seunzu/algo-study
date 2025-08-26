package gold;

import java.io.*;
import java.util.*;

public class boj_5639 {
    static StringBuilder sb = new StringBuilder();
    static int[] pre;
    static int n = 0;

    static void post(int start, int end) {
        if (start > end) return;

        int root = pre[start];

        int idx = start + 1;
        while (idx <= end && pre[idx] < root) {
            idx++;
        }

        post(start + 1, idx - 1);
        post(idx, end);
        sb.append(root).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pre = new int[10000];
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            pre[n++] = Integer.parseInt(line);
        }

        post(0, n - 1);

        System.out.print(sb);
    }
}