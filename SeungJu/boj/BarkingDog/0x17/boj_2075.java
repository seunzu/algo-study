package priorityQueue;

import java.io.*;
import java.util.*;

// N번째 큰 수
public class boj_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (pQ.size() < N) pQ.offer(x);
                else if (pQ.peek() < x) {
                    pQ.poll();
                    pQ.offer(x);
                }
            }
        }
        System.out.println(pQ.peek());
    }
}
