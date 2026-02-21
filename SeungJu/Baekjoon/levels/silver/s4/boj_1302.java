package silver.s4;

import java.io.*;
import java.util.*;

// 베스트셀러
public class boj_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> HM = new TreeMap<>();

        int max = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            HM.put(s, HM.getOrDefault(s, 0) + 1);
            max = Math.max(max, HM.get(s));
        }

        for (Map.Entry<String, Integer> entry : HM.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
