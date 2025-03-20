package ch1_함수.L4;

import java.util.*;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = sc.nextInt();

        int sum = 0;
        while (m >= 1) {
            sum += arr[m];
            if (m == 1) break;

            if (m % 2 == 0) m /= 2;
            else m -= 1;
        }

        System.out.println(sum);
    }
}