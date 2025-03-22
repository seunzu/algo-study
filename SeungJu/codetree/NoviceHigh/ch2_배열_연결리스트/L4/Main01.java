package ch2_배열_연결리스트.L4;

import java.util.*;

// 정수 명령 처리 8
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(sc.nextLine());
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String commandLine = sc.nextLine();
            String[] parts = commandLine.split(" ");
            String cmd = parts[0];

            switch (cmd) {
                case "push_front":
                    list.addFirst(Integer.parseInt(parts[1]));
                    break;
                case "push_back":
                    list.addLast(Integer.parseInt(parts[1]));
                    break;
                case "pop_front":
                    sb.append(list.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(list.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(list.size()).append("\n");
                    break;
                case "empty":
                    sb.append(list.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(list.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(list.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}