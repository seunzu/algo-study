package ch1_함수.L2;

import java.util.*;

// 함수를 이용한 소수 판별
public class Main05 {
    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int solution(int a, int b) {
        int sum = 0;

        for (int i = a; i <= b; i++) {
            if (isPrime(i)) sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(solution(a, b));
    }
}