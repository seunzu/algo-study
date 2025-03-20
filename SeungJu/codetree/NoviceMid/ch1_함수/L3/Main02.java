package ch1_함수.L3;

import java.util.Scanner;

// 짝수만 2로 나누기
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] % 2 == 0) {
                answer[i] = arr[i] / 2;
            } else answer[i] = arr[i];
        }

        for (int i : answer) System.out.print(i + " ");
    }
}