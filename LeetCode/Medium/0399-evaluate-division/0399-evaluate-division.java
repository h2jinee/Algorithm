import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 그래프를 만들기 위한 맵
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        // 그래프 생성
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double quotient = values[i];
            
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());
            
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1.0 / quotient);
        }
        
        // 결과 저장을 위한 배열
        double[] results = new double[queries.size()];
        
        // 각 쿼리에 대해 계산
        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                results[i] = -1.0;
            } else if (dividend.equals(divisor)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, dividend, divisor, 1.0, visited);
            }
        }
        
        return results;
    }
    
    // DFS로 그래프 탐색
    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double value, Set<String> visited) {
        visited.add(current);
        
        if (graph.get(current).containsKey(target)) {
            return value * graph.get(current).get(target);
        }
        
        for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(graph, neighbor.getKey(), target, value * neighbor.getValue(), visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        
        return -1.0;
    }
}