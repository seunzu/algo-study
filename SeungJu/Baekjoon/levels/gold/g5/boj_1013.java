package gold.g5;

import java.io.*;
import java.util.regex.*;

// Contact
public class boj_1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile("^(100+1+|01)+$");
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            if (pattern.matcher(s).matches()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}
