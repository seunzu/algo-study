package twoPointer;

import java.io.*;
import java.util.*;

public class boj_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        int p1 = 0, p2 = 0;
        while(p2 < n) {
            sum += arr.get(p2++);
            while (sum >= s) {
                min = Math.min(min, p2 - p1);
                sum -= arr.get(p1++);
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
