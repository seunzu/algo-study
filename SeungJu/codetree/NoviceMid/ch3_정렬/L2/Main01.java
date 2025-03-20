package ch3_정렬.L2;

import java.util.*;

// 007
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr.add(num);

            if ((i + 1) % 2 == 1) {
                List<Integer> tmp = new ArrayList<>(arr);
                Collections.sort(tmp);
                int mid = tmp.size() / 2;
                sb.append(tmp.get(mid)).append(" ");
            }
        }

        System.out.println(sb);
    }
}