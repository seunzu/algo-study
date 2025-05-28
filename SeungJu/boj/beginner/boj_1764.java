import java.io.*;
import java.util.*;

// 듣보잡
public class boj_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set1.add(br.readLine());
        }

        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < M; i++) {
            set2.add(br.readLine());
        }

        set1.retainAll(set2);

        List<String> result = new ArrayList<>(set1);
        Collections.sort(result);

        System.out.println(result.size());
        for (String s : result) System.out.println(s);
    }
}
