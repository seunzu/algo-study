package ch4_시뮬레이션1.L1;

import java.util.Scanner;

// DateTime to DateTime
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int start = (11 * 24 * 60) + (11 * 60) + 11;
        int end = (A * 24 * 60) + (B * 60) + C;

        System.out.print(end < start ? -1 : end - start);
    }
}