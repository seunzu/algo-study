package silver.s5;

import java.io.*;

// 막대기
public class boj_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (X > 0) {
            if ((X & 1) == 1) cnt++;
            X >>= 1;
        }

        System.out.println(cnt);
    }
}
