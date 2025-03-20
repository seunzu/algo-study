package ch1_함수.L3;

import java.util.Scanner;

// 두 정수에 대한 연산값 2
public class Main07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > b) {
            b += 10;
            a *= 2;
        } else {
            a += 10;
            b *= 2;
        }

        System.out.println(a + " " + b);
    }
}
