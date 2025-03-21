package ch1_함수.L2;

import java.util.*;

// 함수를 이용한 연속부분수열 여부 판단하기
public class Main11 {
    public static void solution(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        for (int i = 0; i <= n1 - n2; i++) {
            boolean match = true;
            for (int j = 0; j < n2; j++) {
                if (a[i + j] != b[j]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] a = new int[n1];
        for (int i = 0; i < n1; i++) a[i] = sc.nextInt();
        int[] b = new int[n2];
        for (int i = 0; i < n2; i++) b[i] = sc.nextInt();

        solution(a, b);
    }
}