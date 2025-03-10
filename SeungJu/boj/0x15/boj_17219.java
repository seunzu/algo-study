package hash;

import java.io.*;
import java.util.*;

// 비밀번호 찾기
public class boj_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> HM = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            String site = input.nextToken();
            String password = input.nextToken();
            HM.put(site, password);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            sb.append(HM.get(str)).append('\n');
        }

        System.out.println(sb);
    }
}
