package ch5_스택_큐_덱.L2;

import java.util.*;

// 정수 명령 처리 2
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(sc.nextLine());
        Queue<Integer> q = new LinkedList<>();

        while (n-- > 0) {
            String commandLine = sc.nextLine();
            String[] parts = commandLine.split(" ");
            String cmd = parts[0];

            switch (cmd) {
                case "push":
                    q.add(Integer.parseInt(parts[1]));
                    break;
                case "pop":
                    sb.append(q.poll()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(q.peek()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}