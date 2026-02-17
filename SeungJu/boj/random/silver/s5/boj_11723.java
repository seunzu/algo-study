package silver.s5;

import java.io.*;
import java.util.*;

// 집합
public class boj_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        int set = 0;
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set |= (1 << x);
            } else if (cmd.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set &= ~(1 << x);
            } else if (cmd.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append((set & (1 << x)) != 0 ? 1 : 0).append("\n");
            } else if (cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                set ^= (1 << x);
            } else if (cmd.equals("all")) {
                set = (1 << 21) - 2;
            } else if (cmd.equals("empty")) {
                set = 0;
            }
        }

        System.out.print(sb);
    }
}