package dataStructures.sort;

import java.io.*;
import java.util.*;

public class Solution {
    static class Student {
        int id;
        String name;
        double cgpa;

        Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine().trim());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            double cgpa = Double.parseDouble(st.nextToken());
            students.add(new Student(id, name, cgpa));
        }

        students.sort((a, b) -> {
            int cmp = Double.compare(b.cgpa, a.cgpa);
            if (cmp != 0) return cmp;

            cmp = a.name.compareTo(b.name);
            if (cmp != 0) return cmp;

            return Integer.compare(a.id, b.id);
        });

        for (Student s : students) {
            sb.append(s.name).append('\n');
        }

        System.out.print(sb);
    }
}