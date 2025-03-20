package ch3_정렬.L3;

import java.util.*;

class User {
    String name;
    int height;
    int weight;

    public User(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public void userInfo() {
        System.out.println(name + " " + height + " " + weight);
    }
}

public class Main06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<User> users = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            users.add(new User(name, height, weight));
        }

        Collections.sort(users, (u1, u2) -> {
            if (u1.height != u2.height) return u1.height - u2.height;
            return u2.weight - u1.weight;
        });

        for (User u : users) u.userInfo();
    }
}