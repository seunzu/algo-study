package Ox03_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Strfry
public class boj_11328 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if (str1.length() != str2.length()) {
                System.out.println("Impossible");
                continue;
            }

            char[] char1 = str1.toCharArray();
            char[] char2 = str2.toCharArray();
            Arrays.sort(char1);
            Arrays.sort(char2);

            System.out.println(Arrays.equals(char1,char2) ? "Possible" : "Impossible");
        }
    }
}
