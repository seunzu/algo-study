package queue;

import java.io.*;
import java.util.*;

// 카드2
public class boj_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) queue.offer(i);

        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.peek());
    }
}
