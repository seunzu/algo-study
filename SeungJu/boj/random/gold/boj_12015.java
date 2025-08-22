package gold;

import java.io.*;
import java.util.*;

// 가장 긴 증가하는 부분 수열 2
public class boj_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> arr = new ArrayList<>();
        for (int a : A) {
            int num = Collections.binarySearch(arr, a);
            if (num < 0) num = -(num + 1);
            if (num == arr.size()) arr.add(a);
            else arr.set(num, a);
        }

        System.out.println(arr.size());
    }
}
