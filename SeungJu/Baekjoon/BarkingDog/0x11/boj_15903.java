package greedy;

import java.io.*;
import java.util.*;

// 카드 합체 놀이
public class boj_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pQ = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pQ.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long a = pQ.poll();
            long b = pQ.poll();
            long sum = a + b;
            pQ.add(sum);
            pQ.add(sum);
        }

        long total = 0;
        while (!pQ.isEmpty()) total += pQ.poll();

        System.out.println(total);
    }
}
