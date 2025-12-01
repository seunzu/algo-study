package priorityQueue;

import java.io.*;
import java.util.*;

// 파일 합치기 3
public class boj_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pQ = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                pQ.add(Long.parseLong(st.nextToken()));
            }

            long totalCost = 0;
            while (pQ.size() > 1) {
                long a = pQ.poll();
                long b = pQ.poll();

                long sum = a + b;
                totalCost += sum;

                pQ.add(sum);
            }

            sb.append(totalCost).append("\n");
        }

        System.out.println(sb);
    }
}
