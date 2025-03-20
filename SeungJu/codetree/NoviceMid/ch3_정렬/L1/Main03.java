package ch3_정렬.L1;

import java.util.*;

// 단어 정렬
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] wordList = new String[n];
        for (int i = 0; i < n; i++) {
            wordList[i] = sc.next();
        }

        Arrays.sort(wordList);
        for (String s : wordList) System.out.println(s);
    }
}
