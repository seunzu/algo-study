import java.io.*;
import java.util.*;

// 최소힙
public class boj_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pQ = new PriorityQueue<>();
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                System.out.println(pQ.isEmpty() ? 0 : pQ.poll());
            } else pQ.offer(x);
        }
    }
}
