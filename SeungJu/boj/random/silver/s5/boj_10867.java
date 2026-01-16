package silver.s5;

import java.io.*;
import java.util.*;

// 중복 빼고 정렬하기
public class boj_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        for (int i : set) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
