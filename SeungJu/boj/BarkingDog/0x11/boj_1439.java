package greedy;

import java.io.*;

// 뒤집기
public class boj_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int zeroCnt = 0;
        int oneCnt = 0;

        char prev =  s.charAt(0);
        if (prev == '0') zeroCnt++;
        else oneCnt++;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                if (s.charAt(i) == '0') zeroCnt++;
                else oneCnt++;
                prev = s.charAt(i);
            }
        }

        System.out.println(Math.min(zeroCnt, oneCnt));
    }
}
