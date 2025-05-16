package hash;

import java.io.*;
import java.util.*;

// 걸그룹 마스터 준석이
public class boj_16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, List<String>> HM1 = new HashMap<>();
        Map<String, String> HM2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine());

            List<String> arr = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                String member = br.readLine();
                arr.add(member);
                HM2.put(member, group);
            }
            HM1.put(group, arr);
        }

        while (m-- > 0) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if (type == 0) {
                List<String> arr = HM1.get(name);
                Collections.sort(arr);
                for (String str : arr) {
                    sb.append(str).append("\n");
                }
            } else {
                sb.append(HM2.get(name)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
