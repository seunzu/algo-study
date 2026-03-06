package LeetCode75.Graphs.DFS;

// Evaluate Division
public class leetcode_399 {
    class Solution {
        class Pair {
            String node;
            double weight;

            Pair(String node, double weight) {
                this.node = node;
                this.weight = weight;
            }
        }

        Map<String, List<Pair>> graph = new HashMap<>();

        void build(List<List<String>> equations, double[] values) {
            for (int i = 0; i < equations.size(); i++) {
                String a = equations.get(i).get(0);
                String b = equations.get(i).get(1);
                double val = values[i];

                graph.putIfAbsent(a, new ArrayList<>());
                graph.putIfAbsent(b, new ArrayList<>());

                graph.get(a).add(new Pair(b, val));
                graph.get(b).add(new Pair(a, 1.0 / val));
            }
        }

        double dfs(String cur, String target, double product, Set<String> visited) {

            visited.add(cur);

            for (Pair next : graph.get(cur)) {
                if (visited.contains(next.node)) continue;

                double newProduct = product * next.weight;
                if (next.node.equals(target)) return newProduct;

                double result = dfs(next.node, target, newProduct, visited);
                if (result != -1.0) return result;
            }

            return -1.0;
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            build(equations, values);

            double[] result = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                String start = queries.get(i).get(0);
                String end = queries.get(i).get(1);

                if (!graph.containsKey(start) || !graph.containsKey(end)) {
                    result[i] = -1.0;
                } else if (start.equals(end)) {
                    result[i] = 1.0;
                } else {
                    Set<String> visited = new HashSet<>();
                    result[i] = dfs(start, end, 1.0, visited);
                }
            }

            return result;
        }
    }
}
