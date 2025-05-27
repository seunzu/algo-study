import java.io.*;
import java.util.*;

// 나는야 포켓몬 마스터 이다솜
public class boj_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> HM1 = new HashMap<>();
        Map<String, Integer> HM2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            HM1.put(i, s);
            HM2.put(s, i);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            if (Character.isDigit(s.charAt(0))) {
                sb.append(HM1.get(Integer.parseInt(s))).append("\n");
            } else sb.append(HM2.get(s)).append("\n");
        }

        System.out.println(sb);
    }
}
