package ch2_재귀함수.L1;

import java.util.Scanner;

// 숫자 차례로 출력하기
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = n; i >= 1; i--) System.out.print(i + " ");
    }
}