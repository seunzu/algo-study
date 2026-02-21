package gold.g4;

import java.io.*;
import java.util.*;

// 전화번호 목록
public class boj_5052 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);

            boolean flag = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i + 1].startsWith(arr[i])) {
                    flag = false;
                    break;
                }
            }

            sb.append(flag ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
