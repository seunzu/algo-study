package ch3_정렬.L1;

import java.util.*;

// 두 개의 동일한 수열
public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        System.out.println(nums[k - 1]);
    }
}