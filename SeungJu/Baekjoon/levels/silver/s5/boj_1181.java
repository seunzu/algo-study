package silver.s5;

import java.io.*;
import java.util.*;

// 단어 정렬
public class boj_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> words = new ArrayList<>(set);
        Collections.sort(words, (a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });

        for (String s : words) sb.append(s).append("\n");

        System.out.println(sb);
    }
}
