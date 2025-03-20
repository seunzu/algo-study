package ch1_함수.L3;

import java.util.Scanner;

// 절댓값으로 변경
public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = Math.abs(num);
        }

        for (int i : arr) System.out.print(i + " ");
    }
}
