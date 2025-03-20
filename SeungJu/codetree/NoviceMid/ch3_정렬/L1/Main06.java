package ch3_정렬.L1;

import java.util.*;

// 2개씩 그룹짓기
public class Main06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) nums[i] = sc.nextInt();

        Arrays.sort(nums);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = nums[i] + nums[2 * n - 1 - i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}