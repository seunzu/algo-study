package ch5_스택_큐_덱.L2;

import java.util.*;

// 원형 순열에서의 인원 제거
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int k = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) dq.offer(i);

        while (!dq.isEmpty()) {
            for (int i = 1; i < k; i++) dq.offerLast(dq.pollFirst());
            sb.append(dq.pollFirst());
            if (!dq.isEmpty()) sb.append(" ");
        }

        System.out.println(sb);
    }
}