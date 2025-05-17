import java.io.*;
import java.util.*;

// 프린터 큐
class Document {
    int index;
    int priority;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class boj_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> queue = new LinkedList<>();
            Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, priority));
                pQ.add(priority);
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                Document curr = queue.poll();

                if (curr.priority == pQ.peek()) {
                    cnt++;
                    pQ.poll();

                    if (curr.index == M) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                } else queue.add(curr);
            }
        }
        System.out.println(sb);
    }
}
