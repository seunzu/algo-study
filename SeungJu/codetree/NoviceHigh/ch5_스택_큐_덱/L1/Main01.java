package ch5_스택_큐_덱.L1;

import java.util.*;

// 정수 명령 처리
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(sc.nextLine());
        Stack<Integer> s = new Stack<>();

        while (n-- > 0) {
            String commandLine = sc.nextLine();
            String[] parts = commandLine.split(" ");
            String cmd = parts[0];

            switch (cmd) {
                case "push":
                    int x = Integer.parseInt(parts[1]);
                    s.push(x);
                    break;
                case "pop":
                    sb.append(s.pop()).append("\n");
                    break;
                case "size":
                    sb.append(s.size()).append("\n");
                    break;
                case "empty":
                    sb.append(s.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(s.peek()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}