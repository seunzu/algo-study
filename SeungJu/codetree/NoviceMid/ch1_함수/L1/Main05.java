package ch1_함수.L1;

import java.util.Scanner;

// 최대공약수 구하기
public class Main05 {
    public static int gcd(int n, int m) {
        if (m == 0) return n;
        return gcd(m, n % m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(gcd(n, m));
    }
}
