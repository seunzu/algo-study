package ch3_정렬.L2;

import java.util.*;

// 비오는 날
class Rain implements Comparable<Rain> {
    String date;
    String day;
    String weather;

    public Rain(String date, String day, String weather) {
        this.date = date;
        this.day = day;
        this.weather = weather;
    }

    public void rainInfo() {
        System.out.println(date + " " + day + " " + weather);
    }

    @Override
    public int compareTo(Rain o) {
        return this.date.compareTo(o.date);
    }
}

public class Main07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Rain> rains = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();
            rains.add(new Rain(date, day, weather));
        }

        List<Rain> rainDays = new ArrayList<>();
        for (Rain r : rains) {
            if (r.weather.equals("Rain")) {
                rainDays.add(r);
            }
        }

        Collections.sort(rainDays);

        rainDays.get(0).rainInfo();
    }
}