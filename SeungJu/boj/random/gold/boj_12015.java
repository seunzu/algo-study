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
            int pos = Collections.binarySearch(arr, a);
            if (pos < 0) pos = -(pos + 1);
            if (pos == arr.size()) arr.add(a);
            else arr.set(pos, a);
        }

        System.out.println(arr.size());
    }
}
