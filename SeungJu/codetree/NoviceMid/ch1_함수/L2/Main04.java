package ch1_함수.L2;

import java.util.*;

// 함수를 이용한 369 게임
public class Main04 {
    static int solution(int a, int b) {
        int cnt = 0;

        for (int i = a; i <= b; i++) {
            String numStr = String.valueOf(i);
            if (numStr.contains("3") || numStr.contains("6") || numStr.contains("9") || i % 3 == 0) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(solution(A, B));
    }
}
