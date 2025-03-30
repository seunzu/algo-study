package binarySearch;

import java.io.*;
import java.util.*;

// 차집합
public class boj_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> bSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        aSet.removeAll(bSet);

        List<Integer> list = new ArrayList<>(aSet);
        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (int i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
