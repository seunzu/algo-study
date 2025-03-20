package ch1_함수.L4;

import java.util.*;

// 특정 구간의 합
public class Main03 {
    static int[] arr;

    public static int getRangeSum(int s, int e) {
        int sum = 0;
        for (int i = s - 1; i <= e - 1; i++) sum += arr[i];
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();

            int result = getRangeSum(a1, a2);
            System.out.println(result);
        }
    }
}