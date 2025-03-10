package hash;

import java.io.*;
import java.util.*;

// 나는야 포켓몬 마스터 이다솜
public class boj_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> HM1 = new HashMap<>();
        Map<String, Integer> HM2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            HM1.put(i, str);
            HM2.put(str, i);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                sb.append(HM1.get(Integer.parseInt(str))).append('\n');
            } else {
                sb.append(HM2.get(str)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
