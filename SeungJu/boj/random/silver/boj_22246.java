package silver;

import java.io.*;
import java.util.*;

// Chairs
class Library implements Comparable<Library> {
    int time, delta;

    Library(int time, int delta) {
        this.time = time;
        this.delta = delta;
    }

    @Override
    public int compareTo(Library o) {
        if (this.time == o.time) return o.delta - this.delta;
        return this.time - o.time;
    }
}

public class boj_22246 {
    static int toSeconds(String s) {
        String[] parts = s.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        int ss = Integer.parseInt(parts[2]);
        return hh * 3600 + mm * 60 + ss;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Library> libraries = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            String in = parts[0];
            String out = parts[1];
            libraries.add(new Library(toSeconds(in), +1));
            libraries.add(new Library(toSeconds(out), -1));
        }

        Collections.sort(libraries);

        int cur = 0, max = 0;
        for (Library l : libraries) {
            cur += l.delta;
            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}
