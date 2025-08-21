package bronze;

import java.io.*;
import java.util.*;

// 점수 계산
public class boj_2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int score = 0;
        int cur = 0;

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(st.nextToken());
            if (M == 1) {
                cur++;
                score += cur;
            } else cur = 0;
        }

        System.out.println(score);
    }
}
