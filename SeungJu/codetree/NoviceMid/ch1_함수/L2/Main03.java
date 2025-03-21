package ch1_함수.L2;

import java.util.Scanner;

// 짝수이면서 합이 5의 배수인 수
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int digitSum = (n / 10) + (n % 10);
        System.out.println(n % 2 == 0 && digitSum % 5 == 0 ? "Yes" : "No");
    }
}
