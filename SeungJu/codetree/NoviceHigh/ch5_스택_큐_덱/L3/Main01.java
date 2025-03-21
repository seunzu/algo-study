package ch5_스택_큐_덱.L3;

import java.util.*;

// 정수 명령 처리 3
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(sc.nextLine());
        Deque<Integer> dq = new ArrayDeque<>();

        while (n-- > 0) {
            String commandLine = sc.nextLine();
            String[] parts = commandLine.split(" ");
            String cmd = parts[0];

            switch (cmd) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(parts[1]));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(parts[1]));
                    break;
                case "pop_front":
                    sb.append(dq.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(dq.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(dq.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(dq.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}