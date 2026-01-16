package bronze;

import java.io.*;
import java.util.*;

// 단어 뒤집기
public class boj_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                sb.append(new StringBuilder(s).reverse()).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
