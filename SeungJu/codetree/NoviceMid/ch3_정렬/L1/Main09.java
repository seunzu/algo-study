package ch3_정렬.L1;

import java.util.*;

// 중앙값 계산 2
public class Main09 {
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