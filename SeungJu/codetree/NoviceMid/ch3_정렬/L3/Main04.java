package ch3_정렬.L3;

import java.util.*;

// 줄 세우기
class Student implements Comparable<Student>{
    int height;
    int weight;
    int index;

    public Student(int height, int weight, int index) {
        this.height = height;
        this.weight = weight;
        this.index = index;
    }

    @Override
    public int compareTo(Student o) {
        if (this.height != o.height) return o.height - this.height;
        return o.weight - this.weight;
    }

    public void studentInfo() {
        System.out.println(height + " " + weight + " " + index);
    }
}

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            students.add(new Student(height, weight, i + 1));
        }

        Collections.sort(students);

        for (Student s : students) s.studentInfo();
    }
}
