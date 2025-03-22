package ch4_시뮬레이션1.L2;

import java.util.Scanner;

// 2진수로 변환하기
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] digits = new int[20];
        int cnt = 0;

        while (true) {
            if (n < 2) {
                digits[cnt++] = n;
                break;
            }

            digits[cnt++] = n % 2;
            n /= 2;
        }

        for (int i = cnt - 1; i >= 0; i--) System.out.print(digits[i]);
    }
}