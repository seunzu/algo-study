package ch1_함수.L1;

import java.util.Scanner;

// 반복 출력하기
public class Main02 {
    public static void printNLines(int n) {
        for (int i = 0; i < n; i++)
            System.out.println("12345^&*()_");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNLines(n);
    }
}
