package silver;

import java.io.*;
import java.util.*;

// 두 수의 합
public class boj_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            int target = x - i;
            if (set.contains(target)) cnt++;
            set.add(i);
        }

        System.out.println(cnt);
    }
}
