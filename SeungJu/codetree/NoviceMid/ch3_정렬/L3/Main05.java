package ch3_정렬.L3;

import java.util.*;

// 개인정보
class User {
    String name;
    int height;
    double weight;

    public User(String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public void userInfo() {
        System.out.println(name + " " + height + " " + weight);
    }
}

public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            double weight = sc.nextDouble();
            users.add(new User(name, height, weight));
        }

        Collections.sort(users, Comparator.comparing(u -> u.name));
        System.out.println("name");
        for (User u : users) u.userInfo();

        System.out.println();

        Collections.sort(users, (u1, u2) -> u2.height - u1.height);
        System.out.println("height");
        for (User u : users) u.userInfo();
    }
}