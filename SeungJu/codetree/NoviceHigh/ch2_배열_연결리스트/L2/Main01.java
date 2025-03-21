package ch2_배열_연결리스트.L2;

import java.util.*;

// 정수 명령 처리
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String commandLine = sc.nextLine();
            String[] parts = commandLine.split(" ");
            String cmd = parts[0];

            switch (cmd) {
                case "push_back":
                    int x = Integer.parseInt(parts[1]);
                    arr.add(x);
                    break;
                case "pop_back":
                    arr.remove(arr.size() - 1);
                    break;
                case "size":
                    sb.append(arr.size()).append("\n");
                    break;
                case "get":
                    int idx = Integer.parseInt(parts[1]) - 1;
                    sb.append(arr.get(idx)).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
