import java.io.*;
import java.util.*;

// 수 이어 쓰기 2
public class boj_1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long len = 1;
        long start = 1;

        while (true) {
            long cnt = 9 * start;
            long digitLen = cnt * len;

            if (k > digitLen) {
                k -= digitLen;
                start *= 10;
                len ++;
            } else break;

            if (start > N) break;
        }

        long num = start + (k - 1) / len;
        if (num > N) System.out.println(-1);
        else {
            String s = Long.toString(num);
            System.out.println(s.charAt((int)((k - 1) % len)));
        }
    }
}
