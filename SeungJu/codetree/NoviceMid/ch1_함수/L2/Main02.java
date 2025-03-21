package ch1_함수.L2;

import java.util.Scanner;

// 정수의 최솟값
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int min = Math.min(Math.min(a, b), c);
        System.out.println(min);
    }
}