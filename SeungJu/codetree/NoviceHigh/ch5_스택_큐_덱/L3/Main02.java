package ch5_스택_큐_덱.L3;

import java.util.*;

// 수열 조작
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) dq.addLast(i);

        while(dq.size() > 1) {
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }

        System.out.println(dq.peekFirst());
    }
}