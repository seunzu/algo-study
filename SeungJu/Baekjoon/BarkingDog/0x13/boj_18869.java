package binarySearch;

import java.io.*;
import java.util.*;

// 멀티버스2
public class boj_18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<List<Integer>, Integer> HM = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            List<Integer> original = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                original.add(arr[j]);
            }

            Set<Integer> set = new HashSet<>(original);
            List<Integer> sorted = new ArrayList<>(set);
            Collections.sort(sorted);

            List<Integer> compressed = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int idx = Collections.binarySearch(sorted, arr[j]);
                compressed.add(idx);
            }

            HM.put(compressed, HM.getOrDefault(compressed, 0) + 1);
        }

        int result = 0;
        for (int count : HM.values()) {
            result += count * (count - 1) / 2;
        }

        System.out.println(result);
    }
}
