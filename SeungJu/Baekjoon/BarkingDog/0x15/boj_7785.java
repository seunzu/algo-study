package hash;

import java.io.*;
import java.util.*;

// 회사에 있는 사람
public class boj_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("enter")) {
                set.add(name);
            } else if (action.equals("leave")) {
                set.remove(name);
            }
        }

        List<String> arr = new ArrayList<>(set);
        arr.sort(Collections.reverseOrder()); // Collections.sort(arr, Collections.reverseOrder());

        for (String name : arr) System.out.println(name);
    }
}
