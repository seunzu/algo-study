package ch1_함수.L1;

import java.util.Scanner;

// 함수를 이용해 직사각형 만들기
public class Main03 {
    public static void printRect(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowNum = sc.nextInt();
        int colNum = sc.nextInt();
        printRect(rowNum, colNum);
    }
}