package ch2_배열_연결리스트.L5;

import java.io.*;
import java.util.*;

// 황금 비율 토스트
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) list.add(c);
        ListIterator<Character> it = list.listIterator(list.size());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "L":
                    if (it.hasPrevious()) it.previous();
                    break;
                case "R":
                    if (it.hasNext()) it.next();
                    break;
                case "D":
                    if (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                    break;
                case "P":
                    char ch = st.nextToken().charAt(0);
                    it.add(ch);
                    break;
            }
        }

        for (char c : list) System.out.print(c);
    }
}