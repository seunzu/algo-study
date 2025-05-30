import java.io.*;

// 수 이어 쓰기 1
public class boj_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int plus = 1;
        int num = 10;

        for (int i = 1; i <= N; i++) {
            if (i % num == 0) {
                plus++;
                num *= 10;
            }
            cnt += plus;
        }

        System.out.println(cnt);
    }
}
