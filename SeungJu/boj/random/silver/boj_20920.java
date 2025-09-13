package silver;

import java.io.*;
import java.util.*;

// 영단어 암기는 괴로워
public class boj_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() >= M) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        List<String> words = new ArrayList<>(map.keySet());
        Collections.sort(words, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            if (freqA != freqB) return freqB - freqA;
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        for (String s : words) sb.append(s).append("\n");
        System.out.println(sb);
    }
}
