package ch1_함수.L1;

import java.util.Scanner;

// 숫자로 이루어진 사각형
public class Main04 {
    public static void printRect(int n) {
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(num + " ");
                num++;
                if (num == 10) num = 1;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printRect(n);
    }
}
