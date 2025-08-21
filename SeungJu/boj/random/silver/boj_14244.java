package silver;

import java.io.*;
import java.util.*;

// 트리 만들기
public class boj_14244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        sb.append("0 1\n");
        int next = 2;

        for (int i = 0; i < m - 1; i++) {
            sb.append("1 ").append(next).append("\n");
            next++;
        }

        for (int i = next; i < n; i++) {
            sb.append((i - 1)).append(" ").append(i).append("\n");
        }

        System.out.print(sb);
    }
}
