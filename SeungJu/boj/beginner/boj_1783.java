import java.io.*;
import java.util.*;

// 병든 나이트
public class boj_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        if (N == 1) cnt = 1;
        else if (N == 2) {
            cnt = Math.min(4, (M + 1) / 2);
        } else {
            if (M < 7) {
                cnt = Math.min(4, M);
            } else {
                cnt = M - 2;
            }
        }

        System.out.println(cnt);
    }
}
