package ch3_정렬.L1;

import java.util.*;

// 오름 내림차순 정렬
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i : arr) System.out.print(i + " ");
    }
}