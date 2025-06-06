import java.io.*;
import java.util.*;

// 최소, 최대
public class boj_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(st.nextToken());
            min = Math.min(min, M);
            max = Math.max(max, M);
        }

        System.out.println(min + " " + max);
    }
}
