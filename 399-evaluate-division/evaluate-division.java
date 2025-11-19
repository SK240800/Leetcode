class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String,Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b,val);
            graph.get(b).put(a,1.0/val);
        }

        double[] results = new double[queries.size()];

        for(int i =0; i < queries.size(); i++){
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if(!graph.containsKey(start) || !graph.containsKey(end)){
                results[i] = -1.0;
            }
            else if (start.equals(end)){
                results[i]=1.0;
            }
            else{
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph,start,end,1.0,visited);
            }
        }
        return results;
    }
    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double product, Set<String> visited) {
        if (current.equals(target)) return product;
        visited.add(current);
        
        for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(graph, neighbor.getKey(), target, product * neighbor.getValue(), visited);
                if (result != -1.0) return result;
            }
        }
        return -1.0;
    }
}