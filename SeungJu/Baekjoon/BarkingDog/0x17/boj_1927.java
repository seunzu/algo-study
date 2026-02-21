package priorityQueue;

import java.io.*;
import java.util.*;

// 최소 힙
public class boj_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                System.out.println(pQ.isEmpty() ? 0 : pQ.poll());
            } else pQ.offer(x);
        }
    }
}
