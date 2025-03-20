package ch3_정렬.L1;

import java.util.*;

// K번째로 신기한 문자열
public class Main08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        List<String> arr = new ArrayList<>();
        for (String s : words) {
            if (s.startsWith(t)) arr.add(s);
        }

        Collections.sort(arr);

        System.out.println(arr.get(k - 1));
    }
}