import java.io.*;
import java.util.*;

// 카잉 달력
public class boj_6064 {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int answer = -1;
            int lcm = lcm(M, N);

            for (int i = 0; i * M + x <= lcm; i++) {
                int k = i * M + x;

                if ((k - 1) % N + 1 == y) {
                    answer = k;
                    break;
                }
            }

            System.out.println(answer);
        }
    }
}
