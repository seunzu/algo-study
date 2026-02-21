package array;

import java.io.*;
import java.util.*;

// 두 수의 합
public class boj_3273 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = 0, lt = 0, rt = n - 1;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum == x) {
                answer++;
                lt++;
                rt--;
            } else if (sum < x) lt++;
            else rt--;
        }

        // ver2
//        HashSet<Integer> set = new HashSet<>();
//        int answer = 0;
//
//        for (int i : arr) {
//            int target = x - i;
//            if (set.contains(target)) answer++;
//            set.add(i);
//        }

        System.out.println(answer);
    }
}
