package dataStructures.priorityQueue;

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

        int getID() {
            return id;
        }

        String getName() {
            return name;
        }

        double getCGPA() {
            return cgpa;
        }
    }

    static class Priorities {
        List<Student> getStudents(List<String> events) {
            PriorityQueue<Student> pQ = new PriorityQueue<>(
                    (a, b) -> {
                        if (Double.compare(b.getCGPA(), a.getCGPA()) != 0)
                            return Double.compare((b.getCGPA()), a.getCGPA());
                        if (!a.getName().equals(b.getName()))
                            return a.getName().compareTo(b.getName());
                        return Integer.compare(a.getID(), b.getID());
                    }
            );

            for (String e : events) {
                if (e.startsWith("ENTER")) {
                    String[] s = e.split(" ");
                    String name = s[1];
                    double cgpa = Double.parseDouble(s[2]);
                    int id = Integer.parseInt(s[3]);

                    pQ.add(new Student(id, name, cgpa));
                } else pQ.poll();
            }

            List<Student> arr = new ArrayList<>();
            while (!pQ.isEmpty()) arr.add(pQ.poll());

            return arr;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            events.add(br.readLine());
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) System.out.println("EMPTY");
        else {
            for (Student s : students) System.out.println(s.getName());
        }
    }
}
