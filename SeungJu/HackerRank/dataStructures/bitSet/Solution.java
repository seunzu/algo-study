package dataStructures.bitSet;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BitSet b1 = new BitSet(N);
        BitSet b2 = new BitSet(N);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            BitSet lt = (x == 1) ? b1 : b2;

            switch (op) {
                case "AND":
                    lt.and((y == 1) ? b1 : b2);
                    break;
                case "OR":
                    lt.or((y == 1) ? b1 : b2);
                    break;
                case "XOR":
                    lt.xor((y == 1) ? b1 : b2);
                    break;
                case "SET":
                    lt.set(y);
                    break;
                case "FLIP":
                    lt.flip(y);
                    break;
            }

            sb.append(b1.cardinality()).append(" ")
                    .append(b2.cardinality()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
