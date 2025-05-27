import java.io.*;

// 수 이어 쓰기3
public class boj_2154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 100000; i++) {
            sb.append(i);
        }

        System.out.println(sb.toString().indexOf(String.valueOf(N)) + 1);
    }
}
