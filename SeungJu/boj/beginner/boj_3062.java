import java.io.*;

// 수 뒤집기
public class boj_3062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String N = br.readLine();
            String R = new StringBuilder(N).reverse().toString();

            String sum = String.valueOf(Integer.parseInt(N) + Integer.parseInt(R));
            String reversedSum = new StringBuilder(sum).reverse().toString();

            if (sum.equals(reversedSum)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}
