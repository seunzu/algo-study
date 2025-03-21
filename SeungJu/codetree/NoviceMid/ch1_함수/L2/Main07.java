package ch1_함수.L2;

import java.util.*;

// 두 수의 거듭제곱
public class Main07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println((int)Math.pow(a, b));
    }
}
