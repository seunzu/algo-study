import java.io.*;

// 홀수
public class boj_2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.MAX_VALUE;
        int total = 0;

        for (int i = 0; i < 7; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n % 2 != 0) {
                total += n;
                if (n < min) min = n;
            }
        }

        if (total == 0) System.out.println(-1);
        else System.out.println(total + "\n" + min);
    }
}
