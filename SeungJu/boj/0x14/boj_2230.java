package twoPointer;

import java.io.*;
import java.util.*;

public class boj_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);

        int min = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        while (p2 < n && p1 <= p2) {
            int diff = arr.get(p2) - arr.get(p1);
            if (diff >= m) {
                min = Math.min(diff, min);
                p1++;
            } else p2++;
        }
        System.out.println(min);
    }
}
