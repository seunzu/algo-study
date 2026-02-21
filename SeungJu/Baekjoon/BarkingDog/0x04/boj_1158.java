package linkedList;

import java.io.*;
import java.util.*;

// 요세푸스 문제
public class boj_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) deque.offer(i);

        sb.append('<');
        while (!deque.isEmpty()) {
            for (int i = 1; i < K; i++) deque.offerLast(deque.pollFirst());
            sb.append(deque.pollFirst());
            if (!deque.isEmpty()) sb.append(", ");
        }
        sb.append('>');
        System.out.println(sb);
    }
}