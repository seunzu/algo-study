package silver.s3;

import java.io.*;
import java.util.*;

// 파일 정리
public class boj_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String file = br.readLine();
            String[] parts = file.split("\\.");
            String ext = parts[1];
            map.put(ext, map.getOrDefault(ext, 0) + 1);
        }

        for (String s : map.keySet()) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }

        System.out.println(sb);
    }
}
