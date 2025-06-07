import java.io.*;
import java.util.*;

// 변수명
public class boj_16205 {
    public static List<String> parseWords(String s, int n) {
        List<String> result = new ArrayList<>();
        if (n == 2) result = Arrays.asList(s.split("_"));
        else {
            StringBuilder word = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    if (word.length() > 0) {
                        result.add(word.toString());
                    }
                    word = new StringBuilder();
                    word.append(Character.toLowerCase(c));
                } else word.append(c);
            }
            if (word.length() > 0) result.add(word.toString());
        }

        return result;
    }

    public static String capitalize(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String s = st.nextToken();

        List<String> words = parseWords(s, N);

        StringBuilder camel = new StringBuilder();
        camel.append(words.get(0).toLowerCase());
        for (int i = 1; i < words.size(); i++) {
            camel.append(capitalize(words.get(i)));
        }

        StringBuilder snake = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            if (i > 0) snake.append("_");
            snake.append(words.get(i).toLowerCase());
        }

        StringBuilder pascal = new StringBuilder();
        for (String w : words) {
            pascal.append(capitalize(w));
        }

        System.out.println(camel + "\n" + snake + "\n" + pascal);
    }
}
