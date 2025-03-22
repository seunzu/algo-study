package ch4_시뮬레이션1.L2;

import java.util.Scanner;

// 진수 to 진수
public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();

        int decimal = Integer.parseInt(N, A);
        String result = Integer.toString(decimal, B).toUpperCase();
        System.out.println(result);
    }
}