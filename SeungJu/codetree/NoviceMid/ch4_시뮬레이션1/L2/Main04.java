package ch4_시뮬레이션1.L2;

import java.util.Scanner;

// 십진수와 이진수 2
public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String binary = sc.next();
        int num = 0;
        for (char c : binary.toCharArray()) {
            num = num * 2 + (c - '0');
        }
        num *= 17;

        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }

        System.out.print(sb.reverse());
    }
}
