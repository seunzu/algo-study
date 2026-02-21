package sort;

import java.io.*;
import java.util.*;

// 수 정렬하기 2
public class boj_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        for (int num : nums) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
