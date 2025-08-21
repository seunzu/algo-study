package bronze;

import java.io.*;
import java.util.*;

// 단어 공부
public class boj_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().toUpperCase();
        Map<Character, Integer> HM = new HashMap<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            HM.put(c, HM.getOrDefault(c, 0) + 1);
            max = Math.max(max, HM.get(c));
        }

        int cnt = 0;
        char result = '?';
        for (Map.Entry<Character, Integer> entry : HM.entrySet()) {
            if (entry.getValue().equals(max)) {
                cnt++;
                result = entry.getKey();
            }
        }

        System.out.println(cnt > 1 ? '?' : result);
    }
}
