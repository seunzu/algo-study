package hash;

import java.io.*;
import java.util.*;

// 싸이버개강총회
public class boj_19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> entered = new HashSet<>();
        Set<String> completed = new HashSet<>();

        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer log = new StringTokenizer(line);
            if (!log.hasMoreTokens()) continue;

            String time = log.nextToken();
            String name = log.nextToken();

            if (time.compareTo(S) <= 0) {
                entered.add(name);
            } else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
                if (entered.contains(name)) {
                    completed.add(name);
                }
            }
        }

        System.out.println(completed.size());
    }
}