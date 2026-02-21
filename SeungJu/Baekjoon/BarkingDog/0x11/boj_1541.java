package greedy;

import java.io.*;

// 잃어버린 괄호
public class boj_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minus = br.readLine().split("-");
        int result = 0;

        for (int i = 0; i < minus.length; i++) {
            int temp = 0;

            String[] plus = minus[i].split("\\+");
            for (String s : plus) temp += Integer.parseInt(s);

            if (i == 0) result += temp;
            else result -= temp;
        }

        System.out.println(result);
    }
}
