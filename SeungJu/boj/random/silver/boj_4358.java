package silver;

import java.io.*;
import java.util.*;

// 생태학
public class boj_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new TreeMap<>();
        String line;
        int total = 0;

        while ((line = br.readLine()) != null) {
            map.put(line, map.getOrDefault(line, 0) + 1);
            total++;
        }

        for (String s : map.keySet()) {
            double ratio = (map.get(s) * 100.0) / total;
            sb.append(s).append(" ").append(String.format("%.4f", ratio)).append("\n");
        }

        System.out.println(sb);
    }
}
