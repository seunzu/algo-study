package ch1_함수.L2;

import java.util.*;

// 함수를 이용한 온전수 판별
public class Main09 {
    public static boolean onjeonsu(int n) {
        if (n % 2 == 0 || n % 10 == 5 || (n % 3 == 0 && n % 9 != 0)) return false;
        return true;
    }

    public static void solution(int a, int b) {
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if (onjeonsu(i)) cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        solution(A, B);
    }
}