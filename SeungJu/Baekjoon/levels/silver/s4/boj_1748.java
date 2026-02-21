package silver.s4;

import java.io.*;

// 수 이어 쓰기1
public class boj_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int digit = 1;
        int start = 1;
        int result = 0;

        while (start * 10 <= N) {
            int end = start * 10 - 1;
            result += (end - start + 1) * digit;
            start *= 10;
            digit++;
        }

        result += (N - start + 1) * digit;
        System.out.println(result);
    }
}
