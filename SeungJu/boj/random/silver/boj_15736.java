package silver;

import java.io.*;

// 청기 백기
public class boj_15736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println((int) Math.sqrt(N));
    }
}
