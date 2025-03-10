package hash;

import java.io.*;
import java.util.*;

// 패션왕 신해빈
public class boj_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> HM = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                HM.put(type, HM.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for (int count : HM.values()) {
                answer *= (count + 1);
            }

            answer -= 1;
            System.out.println(answer);
        }
    }
}
