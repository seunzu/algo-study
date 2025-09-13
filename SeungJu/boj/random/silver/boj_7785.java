package silver;

import java.io.*;
import java.util.*;

// 회사에 있는 사람
public class boj_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String type = st.nextToken();

            if (type.equals("enter")) arr.add(name);
            else arr.remove(name);
        }

        Collections.sort(arr, Collections.reverseOrder());

        for (String s : arr) sb.append(s).append("\n");

        System.out.println(sb);
    }
}
