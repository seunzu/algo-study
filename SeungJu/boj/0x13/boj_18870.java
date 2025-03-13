package binarySearch;

import java.io.*;
import java.util.*;

// 좌표 압축
public class boj_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> HM = new HashMap<>();
        int rank = 0;
        for (int num : sortedArr) {
            if (!HM.containsKey(num)) {
                HM.put(num, rank++);
            }
        }

        for (int num : arr) {
            sb.append(HM.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}
