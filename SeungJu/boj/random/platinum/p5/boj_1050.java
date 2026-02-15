package platinum.p5;

import java.io.*;
import java.util.*;

public class boj_1050 {
    static final long LIMIT = 1_000_000_000L;
    static final long INF = 1_000_000_001L;

    static class Recipe {
        String result;
        Map<String, Integer> materials = new HashMap<>();

        Recipe(String result) {
            this.result = result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Long> HM = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            long price = Long.parseLong(st.nextToken());
            HM.put(name, price);
        }

        List<Recipe> recipes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] parts = br.readLine().split("=");
            String result = parts[0];
            String[] items = parts[1].split("\\+");

            Recipe recipe = new Recipe(result);
            for (String item : items) {
                int idx = 0;
                while (Character.isDigit(item.charAt(idx))) idx++;
                int cnt = Integer.parseInt(item.substring(0, idx));
                String material = item.substring(idx);

                recipe.materials.put(material, recipe.materials.getOrDefault(material, 0) + cnt);
            }

            recipes.add(recipe);
        }

        boolean updated = true;
        while (updated) {
            updated = false;

            for (Recipe r : recipes) {
                long sum = 0;
                boolean possible = true;

                for (Map.Entry<String, Integer> e : r.materials.entrySet()) {
                    if (!HM.containsKey(e.getKey())) {
                        possible = false;
                        break;
                    }

                    long materialCost = HM.get(e.getKey());
                    if (materialCost > LIMIT / e.getValue()) {
                        sum = INF;
                        break;
                    }

                    long addCost = materialCost * e.getValue();

                    if (sum > LIMIT - addCost) {
                        sum = INF;
                        break;
                    }

                    sum += addCost;
                }

                if (!possible) continue;

                if (!HM.containsKey(r.result) || HM.get(r.result) > sum) {
                    HM.put(r.result, sum);
                    updated = true;
                }
            }
        }

        if (!HM.containsKey("LOVE")) System.out.println(-1);
        else if (HM.get("LOVE") > LIMIT) System.out.println(1000000001);
        else System.out.println(HM.get("LOVE"));
    }
}