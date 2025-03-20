package ch1_함수.L3;

import java.util.Scanner;

// 두 정수에 대한 연산값
public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > b) {
            a += 25;
            b *= 2;
        } else {
            b += 25;
            a *= 2;
        }

        System.out.println(a + " " + b);
    }
}