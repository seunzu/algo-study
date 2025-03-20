package ch1_함수.L3;

import java.util.Scanner;

// 두 정수 값 교환하기
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int tmp = n;
        n = m;
        m = tmp;
        System.out.println(n + " " + m);
    }
}