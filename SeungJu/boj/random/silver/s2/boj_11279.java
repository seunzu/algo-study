package silver.s2;

import java.io.*;
import java.util.*;

// 최대 힙
public class boj_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(pQ.isEmpty() ? 0 : pQ.poll()).append("\n");
            } else pQ.offer(x);
        }

        System.out.println(sb);
    }
}
