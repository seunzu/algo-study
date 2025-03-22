package ch4_시뮬레이션1.L2;

import java.util.Scanner;

// 십진수로 변환하기
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String binary = sc.next();
        int num = 0;

        for (char c : binary.toCharArray()) {
            num = num * 2 + (c - '0');
        }

        System.out.print(num);
    }
}