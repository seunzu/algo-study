package ch2_재귀함수.L1;

import java.util.Scanner;

// 재귀함수의 꽃
public class Main04 {
    public static void f(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        f(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
    }
}