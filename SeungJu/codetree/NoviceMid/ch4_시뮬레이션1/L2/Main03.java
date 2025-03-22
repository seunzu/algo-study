package ch4_시뮬레이션1.L2;

import java.util.Scanner;

// 여러가지 진수변환
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int b = sc.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        while (n > 0) {
            sb.append(n % b);
            n /= b;
        }

        System.out.print(sb.reverse());
    }
}