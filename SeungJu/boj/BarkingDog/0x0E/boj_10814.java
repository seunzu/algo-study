package sort;

import java.util.*;

class Person implements Comparable<Person> {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}

public class boj_10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            String y = sc.next();
            arr.add(new Person(x, y));
        }

//        arr.sort(Comparator.comparingInt(p -> p.age));
        Collections.sort(arr);
        for (Person p : arr) System.out.println(p.age + " " + p.name);
    }
}
