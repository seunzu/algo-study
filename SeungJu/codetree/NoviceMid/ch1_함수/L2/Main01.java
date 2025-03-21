package ch1_함수.L2;

import java.util.Scanner;

// 1부터 특정 수까지의 합
public class Main01 {
    public static int totalNum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum / 10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(totalNum(n));
    }
}
