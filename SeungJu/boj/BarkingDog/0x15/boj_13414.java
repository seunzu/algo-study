package hash;

import java.io.*;
import java.util.*;

// 수강신청
public class boj_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String num = br.readLine();
            set.remove(num);
            set.add(num);
        }

        int count = 0;
        for (String str : set) {
            if (count++ == k) break;
            System.out.println(str);
        }
    }
}